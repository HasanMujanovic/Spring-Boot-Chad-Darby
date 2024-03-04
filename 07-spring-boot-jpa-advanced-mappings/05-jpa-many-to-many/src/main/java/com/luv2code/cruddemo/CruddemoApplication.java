package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;
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
//			createCourseAndStudents(appDAO);
//			findCourseAndStudents(appDAO);
//			findStudentAndCourses(appDAO);
//			addMoreCoursesForStudent(appDAO);
//			deleteCourse(appDAO);
			deleteStudent(appDAO);
		};

	}

	private void deleteStudent(AppDAO appDAO) {
		int id = 1;
		System.out.println("Deleting student with id: "+ id);

		appDAO.deleteStudentById(id);

		System.out.println("Done!!!!");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int id = 2;

		Student student = appDAO.findStudentAndCoursesByStudentId(id);

		// create more courses
		Course course1 = new Course("Rubiks cube - how to speed cube");
		Course course2 = new Course("Atari 2600 - game development");

		// add courses to student
		student.addCourse(course1);
		student.addCourse(course2);

		System.out.println("Update student: " + student);
		System.out.println("Associated courses: " + student.getCourses());

		appDAO.updateStudent(student);

		System.out.println("Done!!!!!!");
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int id = 2;
		Student student = appDAO.findStudentAndCoursesByStudentId(id);

		System.out.println("Loaded student: " + student);
		System.out.println("Associated courses for student: " + student.getCourses());

		System.out.println("Done!!!!");
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int id = 10;
		Course course = appDAO.findCourseAndStudentsByCourseId(id);

		System.out.println("Loaded course: " + course);
		System.out.println("Students: " + course.getStudents());

		System.out.println("Done!!!!!");
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		// create course
		Course course = new Course("Pacman - how to score one MIL points");

		// create the students
		Student student = new Student("Hasan","Mujanovic","mujanovich100@gmail.com");
		Student student2 = new Student("Chad","Darby","loves2code@gmail.com");

		// add students to the courses
		course.addStudent(student);
		course.addStudent(student2);

		// save the courses adn associated students
		System.out.println("Saving the course: " + course);
		System.out.println("associated students: " + course.getStudents());

		appDAO.saveCourse(course);

		System.out.println("Done!!!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 10;

		System.out.println("deleting course with id: " + id);

		appDAO.deleteCourseById(id);

		System.out.println("Done!!!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		// get the course and reviews
		int id = 10;
		Course course = appDAO.findCourseAndReviewsByCourseId(id);

		// print the course
		System.out.println(course);
		// print the reviews
		System.out.println(course.getReviews());

		System.out.println("Done!!!!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// create a course
		Course course = new Course("Pacman - How to score million points");

		// add some reviews
		course.addReview(new Review("Great course... love it"));
		course.addReview(new Review("Didn't like it that much"));
		course.addReview(new Review("Well done"));

		// save the course ... and leverage the cascade All(it will save reviews too)
		System.out.println("Saving course");
		System.out.println(course);
		System.out.println(course.getReviews());

		appDAO.saveCourse(course);

		System.out.println("Done!!");

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
