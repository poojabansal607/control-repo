package com.sapient.assessment.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.assessment.dao.AssessmentDao;
import com.sapient.assessment.data.assessments.ResponseAssessment;
import com.sapient.assessment.data.assessments.SubCatAssessment;
import com.sapient.assessment.data.reference.*;
import com.sapient.assessment.service.AssessmentService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by djai10 on 10/4/2016.
 */
public class AssessmentServiceImpl implements AssessmentService {
	private final AssessmentDao assessmentDao;

	public AssessmentServiceImpl(AssessmentDao assessmentDao) {
		this.assessmentDao = assessmentDao;
	}

	public List<RootArea> getAssessmentData(long project_key) {
		List<RootArea> rootAreas = assessmentDao.getRootAreas();
		return updateWithCategories(rootAreas, project_key);
	}

	// Newly added method to fetch root area by name
	public RootArea getAssessmentDataByRootArea(String name) {
		RootArea rootAreas = assessmentDao.getRootAreaByName(name);
		return updateWithCategories(rootAreas);
	}

	public void saveAssessmentData(ResponseAssessment response) {

		// fetch testId for a assessment
		long testId = assessmentDao.getTestId(response.getProjectId());

		// check whether the assessment of that project has been started, if
		// testId=0 start test for that project
		if (testId == 0) {
			assessmentDao.beginAssessment(response.getProjectId());
			testId = assessmentDao.getTestId(response.getProjectId());
		}

		// Delete previous records of that assessment
		deleteAssessmentData(testId);

		// Saving process begins per subcategory wise

		for (SubCatAssessment subcat : response.getSubCat()) {
			// saving user comments of a subCategory for a respective assessment

			assessmentDao.saveComments(testId, subcat.getId(), subcat.getComments());
			// saving maturity_level of a subCategory for a respective
			// assessment
			assessmentDao.saveMaturityLevel(testId, subcat.getId(), subcat.getMaturityLevel());

			// saving the response details per subCategoty wise,
			// only metadata regarding a selected question will be saved,
			// questionId itself would be stored in another table

			for (Long ques : subcat.getCheckedQuestion()) {
				assessmentDao.saveResponseDetails(testId, subcat.getId(), ques);
				// Fetching the response id against which the previous metadata
				// was saved

				long responseId = assessmentDao.getUniqueResponseDetails(testId, subcat.getId());

				assessmentDao.saveResponseValues(responseId, ques);

			}

		}

		// All the question id are now saved

	}

	private List<Question> getQuestions(SubCategoryKey subCategoryKey) {
		return assessmentDao.getQuestions(subCategoryKey.getId());
	}

	private List<SubCategory> getSubCategories(CategoryKey categoryKey, long project_key) {
		List<SubCategory> subCategories = assessmentDao.getSubCategories(categoryKey.getId());
		return updateWithQuestions(subCategories, project_key);
	}

	private List<SubCategory> updateWithQuestions(List<SubCategory> subCategories, long project_key) {
		List<SubCategory> updatedSubCategoryList = new ArrayList<SubCategory>(subCategories.size());
		if (project_key == 0) {
			for (SubCategory subCategory : subCategories) {
				List<Question> questions = getQuestions(subCategory.getSubCategoryKey());
				updatedSubCategoryList.add(
						new SubCategory(subCategory.getSubCategoryKey(), subCategory.getName(), questions, null, null));
			}

			return updatedSubCategoryList;
		} else {

			System.out.println("Inside checked question");
			List<Question> checkedQuestions = assessmentDao.getCheckedQuestion(project_key);
			for (SubCategory subCategory : subCategories) {
				List<Question> questions = getQuestions(subCategory.getSubCategoryKey());
				for (Question ques : checkedQuestions) {
					if (questions.contains(ques)) {
						int i = questions.indexOf(ques);
						questions.get(i).setChecked(true);
					}
				}

				String comments = assessmentDao.getUserCommentsSubCat(project_key,
						subCategory.getSubCategoryKey().getId());
				String maturityLevel = assessmentDao.getMaturityLevelSubCat(project_key,
						subCategory.getSubCategoryKey().getId());
				updatedSubCategoryList.add(new SubCategory(subCategory.getSubCategoryKey(), subCategory.getName(),
						questions, comments, maturityLevel));
			}

			return updatedSubCategoryList;
		}

	}

	private List<Category> getCategories(RootAreaKey rootAreaKey, long project_key) {
		List<Category> categories = assessmentDao.getCategories(rootAreaKey.getId());
		return updateWithSubCategories(categories, project_key);
	}

	private List<Category> updateWithSubCategories(List<Category> categories, long project_key) {
		List<Category> updatedCategoryList = new ArrayList<Category>(categories.size());
		for (Category category : categories) {
			List<SubCategory> subCategories = getSubCategories(category.getCategoryKey(), project_key);
			updatedCategoryList.add(new Category(category.getCategoryKey(), category.getName(), subCategories));
		}

		return updatedCategoryList;
	}

	private List<RootArea> updateWithCategories(List<RootArea> rootAreas, long project_key) {
		List<RootArea> updatedRootAreas = new ArrayList<RootArea>(rootAreas.size());
		for (RootArea rootArea : rootAreas) {
			List<Category> categories = getCategories(rootArea.getRootAreaKey(), project_key);
			updatedRootAreas.add(new RootArea(rootArea.getRootAreaKey(), rootArea.getName(), categories));
		}

		return updatedRootAreas;
	}

	// new method
	private RootArea updateWithCategories(RootArea rootAreas) {
		List<Category> categories = getCategories(rootAreas.getRootAreaKey(), 0);
		RootArea New_rootAreas = new RootArea(rootAreas.getRootAreaKey(), rootAreas.getName(), categories);

		return New_rootAreas;
	}
	// Newly added method to fetch questions by subcat

	public List<Question> getQuestionBySubCat(long project_key, String subcat_name) {
		List<Question> question_subcat = assessmentDao.getSubCategoryQuestion(subcat_name);
		long subCatId = assessmentDao.getSubCatID(subcat_name);

		List<Question> question_checked_subcat = assessmentDao.getCheckedQuestionSubCat(project_key, subCatId);

		for (Question ques : question_checked_subcat) {
			if (question_subcat.contains(ques)) {
				int i = question_subcat.indexOf(ques);
				question_subcat.get(i).setChecked(true);
			}
		}

		return question_subcat;
	}

	// BEGIN ASSESSMENT FOR A PARTICULAR PROJECT
	public void beginAssessment(long projectKey) {
		assessmentDao.beginAssessment(projectKey);

	}

	public void deleteAssessmentData(long testId) {
		// Fetch all the responseID's for a particular test
		List<Long> responseID = assessmentDao.getresponseDetails(testId);

		// Delete questions for every responseId from the response_value table,
		// delete from response_value first because of foreign key constraint
		for (Long responseId : responseID) {
			assessmentDao.deleteSelectedQuestions(responseId);
		}

		// After Deletion from response_value, delete data from response_details
		assessmentDao.deleteresponseDetails(testId);

		// Delete maturity_level for the subCategory
		assessmentDao.deleteMaturityLevel(testId);

		// Delete user comments for the subCategory
		assessmentDao.deleteUserComments(testId);

		// All the data corresponding to a particular test would be deleted

	}

	public long getTestId(long projectKey) {
		// TODO Auto-generated method stub
		return 0;
	}

}
