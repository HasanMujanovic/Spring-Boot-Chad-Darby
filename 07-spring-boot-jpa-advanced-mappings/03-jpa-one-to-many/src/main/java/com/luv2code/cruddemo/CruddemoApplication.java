package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);
//			createInstructorWithCourses(appDAO);
//			findInstructorWithCourses(appDAO);
//			findCoursesForInstructor(appDAO);
//			findInstructorWithCoursesJoinFetch(appDAO);
//			updateInstructor(appDAO);
//			updateCourse(appDAO);
//			deleteInstructor(appDAO);
			deleteCourse(appDAO);
		};

	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 10;

		System.out.println("Deleting course with id: " + id);

		appDAO.deleteCourseById(id);

		System.out.println("Done!!!");
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;

		System.out.println("Finding course with id: " + id);
		Course course = appDAO.findCourseById(id);

		// update course
		System.out.println("Updating course with id: " + id);
		course.setTitle("Hasan Babusan, part2");

		appDAO.updateCourse(course);

		System.out.println("Done!!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;

		System.out.println("Finding insc with id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);

		// update Instructor
		System.out.println("Updating instructor id: " + id);
		instructor.setLastName("MUJANOVIC");

		appDAO.update(instructor);

		System.out.println("Done!!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding insc with id: " + id);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("instructor: " + instructor);
		System.out.println("the associated courses: " + instructor.getCourses());

		System.out.println("Done!");


	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding insc id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("instructor: " + instructor);

		// find courses for instructor
		System.out.println("Finding courses for instructor id: " + id);
		List<Course> courses = appDAO.findCoursesByInstructorId(id);

		// associate courses
		instructor.setCourses(courses);

		System.out.println("the associated courses: " + instructor.getCourses());

		System.out.println("Done!!");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;

		System.out.println("Finding insc id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("instructor: " + instructor);
		System.out.println("the associated courses: " + instructor.getCourses());

		System.out.println("Done!!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Hasan", "Mujanovic","mujanovich100@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("https://www.youtube.com/", "Hasanov hobi");
		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create courses
		Course course1 = new Course("Air guitar - The ultimate Guide");
		Course course2 = new Course("The paintball Master");

		// add courses to instructor
		tempInstructor.add(course1);
		tempInstructor.add(course2);

		// save the instructor
		//
		// NOTE this will also save the courses
		// because of CascadeType.PERSIST
		//
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 3;
		System.out.println("Deleting instructor detail id: " + id);

		appDAO.deleteInstructorDetailById(id);

		System.out.println("Done!!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		// get the instructor detail object
		int id =2;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(2);

		// print this instructor detail
		System.out.println("instructorDetail: " + instructorDetail);

		// print associated instructor
		System.out.println("the associated instructor: " + instructorDetail.getInstructor());

		System.out.println("Done!!!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Deleting instructor id: " + id);

		appDAO.deleteInstructorById(id);

		System.out.println("Done!!");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding the instructor with id: " + id);

		Instructor tempInstructor = appDAO.findInstructorById(id);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated instructorDetails only: " +
				tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
/*
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Chad", "Darby","darby@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("https://www.youtube.com/", "luv 2 code");
*/
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Hasan", "Mujanovic","mujanovich100@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("https://www.youtube.com/", "Hasanob hobi");


		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// NOTE  this will also save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done!!");
	}

}
