package com.sapient.assessment.application;

import com.sapient.assessment.configuration.DevOpsAssessmentConfiguration;
import com.sapient.assessment.dao.AssessmentDao;
import com.sapient.assessment.dao.ClientDao;
import com.sapient.assessment.dao.LoginDAO;
import com.sapient.assessment.dao.ProjectDAO;
import com.sapient.assessment.dao.RegisterDAO;
import com.sapient.assessment.health.TemplateHealthCheck;
import com.sapient.assessment.resources.AssessmentResource;
import com.sapient.assessment.resources.ClientResource;
import com.sapient.assessment.resources.DevopsAssessmentResource;
import com.sapient.assessment.resources.LoginResource;
import com.sapient.assessment.resources.NewRootAreaResource;
import com.sapient.assessment.resources.ProjectResource;
import com.sapient.assessment.resources.QuestionSubCategory;
import com.sapient.assessment.resources.Register;
import com.sapient.assessment.service.implementation.AssessmentServiceImpl;
import com.sapient.assessment.service.implementation.ClientServiceImpl;
import com.sapient.assessment.service.implementation.LoginServiceImpl;
import com.sapient.assessment.service.implementation.ProjectServiceImpl;
import com.sapient.assessment.service.implementation.RegisterServiceImpl;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.skife.jdbi.v2.DBI;

public class DevOpsAssessmentApplication extends Application<DevOpsAssessmentConfiguration> {
    public static void main(String[] args) throws Exception {
       /* Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://D:\\assessment\\db\\devops-assessment.accdb");
*/

        new DevOpsAssessmentApplication().run(args);
    }


    @Override
    public void run(DevOpsAssessmentConfiguration configuration, Environment environment) throws Exception {
        final DevopsAssessmentResource resource = getDevopsAssessmentResource(configuration);
        final DBI jdbi = initializeDB(configuration, environment);
        final ClientResource clientResource = getClientResource(jdbi);
        final AssessmentResource assessmentResource = getAssessmentResource(jdbi);
        final  NewRootAreaResource  newRootAreaResource = getNewRootAreaResource(jdbi);
        final QuestionSubCategory questionSubCategory = getQuestionSubCategory(jdbi);
        final LoginResource login = getLogin(jdbi);
        final Register register=getRegister(jdbi);
        final ProjectResource projectResource = getProjectResource(jdbi);
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
        environment.jersey().register(clientResource);
        environment.jersey().register(assessmentResource);
        environment.jersey().register( newRootAreaResource);
        environment.jersey().register(questionSubCategory);
        environment.jersey().register(login);
        environment.jersey().register(register);
        environment.jersey().register(projectResource);
        environment.getApplicationContext().addFilter(CrossDomainFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST, DispatcherType.ERROR));
    }

    DBI initializeDB(DevOpsAssessmentConfiguration configuration, Environment environment) {
        final DBIFactory factory = new DBIFactory();
        DataSourceFactory dataSourceFactory = new DataSourceFactory();
        return factory.build(environment, configuration.getDataSourceFactory(), "ucanaccess");
    }

    private ClientResource getClientResource(DBI jdbi) {
        final ClientDao dao = jdbi.onDemand(ClientDao.class);
        return new ClientResource(new ClientServiceImpl(dao));
    }
    private AssessmentResource getAssessmentResource(DBI jdbi) {
        final AssessmentDao assessmentDao = jdbi.onDemand(AssessmentDao.class);
        final ProjectDAO projectDao = jdbi.onDemand(ProjectDAO.class);
        return new AssessmentResource(new AssessmentServiceImpl(assessmentDao, projectDao));
    }

    //New Method

    private NewRootAreaResource getNewRootAreaResource(DBI jdbi) {
        final AssessmentDao assessmentDao = jdbi.onDemand(AssessmentDao.class);
        final ProjectDAO projectDao = jdbi.onDemand(ProjectDAO.class);
        return new  NewRootAreaResource(new AssessmentServiceImpl(assessmentDao, projectDao));
    }

    //New Method for question of subcategory
    private QuestionSubCategory  getQuestionSubCategory (DBI jdbi) {
        final AssessmentDao assessmentDao = jdbi.onDemand(AssessmentDao.class);
        final ProjectDAO projectDao = jdbi.onDemand(ProjectDAO.class);
        return new  QuestionSubCategory(new AssessmentServiceImpl(assessmentDao, projectDao));
    }

    //New Method for Login Verification
    private LoginResource getLogin(DBI jdbi){
    	final LoginDAO logindao = jdbi.onDemand(LoginDAO.class);
    	final ClientDao clientdao = jdbi.onDemand(ClientDao.class);

    	return new LoginResource(new LoginServiceImpl(logindao,clientdao));


    }
    private Register getRegister(DBI jdbi) {
        final RegisterDAO registerdao = jdbi.onDemand(RegisterDAO.class);
        return new Register(new RegisterServiceImpl(registerdao));
    }

    private ProjectResource getProjectResource(DBI jdbi){
    	final ProjectDAO projectDao = jdbi.onDemand(ProjectDAO.class);
    			return new ProjectResource (new ProjectServiceImpl(projectDao));
    }


    private DevopsAssessmentResource getDevopsAssessmentResource(DevOpsAssessmentConfiguration configuration) {
        return new DevopsAssessmentResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
    }

    @Override
    public void initialize(Bootstrap<DevOpsAssessmentConfiguration> bootstrap) {

    }


}