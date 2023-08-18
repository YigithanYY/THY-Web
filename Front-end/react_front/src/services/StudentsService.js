import axios from "axios";

const STUDENT_BASE_REST_API_URL = 'http://localhost:8080/api/students';

const STUDENT_ADD_REST_API_URL = 'http://localhost:8080/api/students/add';

const CITY_BASE_REST_API_URL = 'http://localhost:8080/api/cities'


const DISTRICT_BASE_REST_API_URL = 'http://localhost:8080/api/districts/bycity'

class StudentService{

    getAllStudents(){

        return axios.get(STUDENT_BASE_REST_API_URL);
    }

    createStudent(student){
        return axios.post(STUDENT_ADD_REST_API_URL,student);
    }

    getStudentById(studentId){
        return axios.get(STUDENT_BASE_REST_API_URL+"/"+studentId);
    }

    updateStudent(studentId, student){
        return axios.put(STUDENT_BASE_REST_API_URL+"/update/"+studentId,student);
    }

    deleteStudent(studentId){
        return axios.delete(STUDENT_BASE_REST_API_URL+"/delete/"+studentId);
    }

    getCities(){
        return axios.get(CITY_BASE_REST_API_URL);
    }

    getDistrictsByCityId(cityId){
        return axios.get(DISTRICT_BASE_REST_API_URL+"/"+cityId);
    }

}

export default new StudentService();