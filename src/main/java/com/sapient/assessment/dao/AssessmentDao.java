package com.sapient.assessment.dao;

import com.sapient.assessment.dao.mapper.CategoryMapper;
import com.sapient.assessment.dao.mapper.QuestionMapper;
import com.sapient.assessment.dao.mapper.ResponseMapper;
import com.sapient.assessment.dao.mapper.RootAreaMapper;
import com.sapient.assessment.dao.mapper.SubCategoryMapper;
import com.sapient.assessment.data.reference.*;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * Created by djai10 on 10/4/2016.
 */
public interface AssessmentDao {
	@SqlQuery("select * from maturity_model")
	@Mapper(RootAreaMapper.class)
	List<RootArea> getRootAreas();

	//Newly added method to fetch id of subcategory by name
	@SqlQuery("select id from  sub_category where sub_category_name = :SubCat")
	int getSubCatID(@Bind("SubCat")String  SubCategoryName);
	//----------------------------------------------


	//Newly added method to fetch id of category by name
	@SqlQuery("select id from category where name = :CatName")
	int getCatID(String  CatName);
	//----------------------------------------------


	//Newly added method to fetch questions for a subcategory
	@SqlQuery("select * from question q INNER JOIN (select id from  sub_category where sub_category_name = :SubCat)as subcat on q.sub_category_id=subcat.id")
	@Mapper(QuestionMapper.class)
	List<Question>getSubCategoryQuestion(@Bind("SubCat") String SubCategoryName);
	//----------------------------------------------

	//Newly added method to fetch root area by name
	@SqlQuery("select * from maturity_model where name = :name")
	@Mapper(RootAreaMapper.class)
	RootArea getRootAreaByName(@Bind("name") String name);
    //----------------------------------------------


	@SqlQuery("select * from category where root_id = :id")
	@Mapper(CategoryMapper.class)
	List<Category> getCategories(@Bind("id") long rootAreaKey);

	@SqlQuery("select * from sub_category where category_id = :id")
	@Mapper(SubCategoryMapper.class)
	List<SubCategory> getSubCategories(@Bind("id") long id);

	@SqlQuery("select * from question where sub_category_id = :id")
	@Mapper(QuestionMapper.class)
	List<Question> getQuestions(@Bind("id") long id);




	//returned checked questions
	@SqlQuery("select rd.question_id from response_details as rd INNER JOIN assessment on rd.test_id=assessment.test_id and assessment.project_id = :project_key and rd.sub_category_id = :subCatId ")
	@Mapper(ResponseMapper.class)
	List<Question> getCheckedQuestionSubCat(@Bind("project_key") long project_key, @Bind("subCatId") long subCatId);




	//return all questions

	@SqlQuery("select * from question")
	@Mapper(QuestionMapper.class)
	List<Question> getAllQuestions();


	//begin test for a particular project
	@SqlUpdate("Insert into assessment(project_id,test_date) values(:project_key,CURRENT_TIMESTAMP () )")
	void beginAssessment(@Bind("project_key") long projectKey);

	//fetch test_id of a particular project
	@SqlQuery("select test_id from assessment where project_id= :ProjectID")
	long getTestId(@Bind("ProjectID") long projectId);

	//insert comments for a subcategory for a assessment
	@SqlUpdate("Insert into user_comment(test_id,sub_category_id,user_comments) values(:testId,:subCatId,:userComment)")
	void saveComments(@Bind("testId")long testId, @Bind("subCatId") long subCatId, @Bind("userComment") String userComment);

	//insert maturity_level of a subcategory for a assessment
	@SqlUpdate("Insert into subcat_maturity_level (test_id,sub_category_id,maturity_level_value) values (:testId,:subCatId,:maturityLevel)")
	void saveMaturityLevel(@Bind("testId")long testId, @Bind("subCatId") long subCatId, @Bind("maturityLevel") String maturityLevel);

	//insert metadata about a selected question for a subacategory in the response_details
	@SqlUpdate("Insert into response_details(test_id,sub_category_id,question_id) values (:testId,:subCatId,:questionId)")
	void saveResponseDetails(@Bind("testId")long testId, @Bind("subCatId") long subCatId,@Bind("questionId") long questionId);


	//insert question id for the response metadata
	@SqlUpdate("INSERT into response_value(response_id,question_id) values (:responseId,:questionId)")
	void saveResponseValues(@Bind("responseId") long responseId, @Bind("questionId") long questionId);

	//delete previous questions from the response_value table
	@SqlUpdate("DELETE from response_value where response_id = :responseId;")
	void deleteSelectedQuestions(@Bind("responseId")long responseId);

	//select all the response id's from the response_details table for a given test
	@SqlQuery("select response_id from response_details where test_id = :testId")
	List<Long> getresponseDetails(@Bind("testId") long testId);

	//delete data from the response_details on the basis of testId
	@SqlUpdate("Delete from response_details where test_id= :testId")
	void deleteresponseDetails(@Bind("testId") long testId);

	//delete data from user_comments on the basis of test_id
	@SqlUpdate("Delete from user_comment where test_id= :testId")
	void deleteUserComments(@Bind("testId") long testId);

	//delete data from subcat_maturity_level on the basis of test_id
	@SqlUpdate("Delete from subcat_maturity_level where test_id = :testId")
	void deleteMaturityLevel(@Bind("testId") long testId);

	//fetch unique response id based on testId and subCatId
	@SqlQuery("Select response_id from response_details where test_id=:testId AND sub_category_id=:subCatId")
	long getUniqueResponseDetails(@Bind("testId")long testId, @Bind("subCatId")long subCatId);

	//fetch user comments for a particular subcategory of given project
	@SqlQuery("Select user_comments from user_comment INNER JOIN (Select test_id from assessment where assessment.project_id = :projectId) as test ON user_comment.test_id=test.test_id and user_comment.sub_category_id= :subCat")
	String getUserCommentsSubCat(@Bind("projectId") long projectId, @Bind("subCat") long subCatId);

	//fetch maturity level of a subcategory for a particular test
	@SqlQuery("Select maturity_level_value from subcat_maturity_level INNER JOIN (Select test_id from assessment where assessment.project_id = :projectId) as test ON subcat_maturity_level.test_id=test.test_id and subcat_maturity_level.sub_category_id= :subCat")
	String getMaturityLevelSubCat(@Bind("projectId") long projectId, @Bind("subCat") long subCatId);
}
