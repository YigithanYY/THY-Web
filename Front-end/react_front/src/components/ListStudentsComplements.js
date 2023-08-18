import React, {useEffect, useState}  from 'react'
import StudentsService from '../services/StudentsService'
import { useNavigate } from 'react-router-dom'
import { Button } from 'primereact/button';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';

                

const ListStudentsComplenents = () => {

    const [students, setStudents] = useState([])
    const navigator = useNavigate()

    useEffect(() =>{

      getAllStudents();
    },[])

    const getAllStudents = () =>{
      StudentsService.getAllStudents().then((Response) =>{
        setStudents(Response.data)

    }).catch(error =>{
        console.log(error);
    })

    }

    const deleteStudent=(studentId)=>{
      console.log(studentId)
      StudentsService.deleteStudent(studentId).then((response)=>{
        getAllStudents();

      }).catch(error=>{
        console.log(error);
      })

    }
     const buttonFuctions = (students)=>{
      return (<div > 
        <Button style={{color:'white'}}label='Update'onClick={()=> navigator("/students/update/"+students.studentId) }></Button>
        <Button style={{marginLeft:'1vw',color:'white'}} label='Delete'onClick={()=> deleteStudent(students.studentId)}></Button>

      </div>)
     }
    




  return (
    <div className= 'container'style={{marginTop:'1vh'}}>
      
      <Button style={{color:'white',marginBottom:'1vh',marginTop:'1vh'}}label='Öğrenci ekle'onClick={()=> navigator("/students/add") }></Button>

      <DataTable value={students}>
            <Column field='studentId' header="Öğrenci no"></Column>
            <Column field="firstName" header="Öğrenci adı"></Column>
            <Column field="lastName" header="Öğrenci soyadı"></Column>
            <Column field="phoneNumber" header="Öğrenci tel"></Column>
            <Column field="cityId" header="Şehir no"></Column>
            <Column field="districtId" header="İlçe no"></Column>
            <Column field="description" header="Açıklama"></Column>
            <Column  header="İslemler" body={buttonFuctions} ></Column>

        </DataTable>
        

    </div>
  )
}

export default ListStudentsComplenents
