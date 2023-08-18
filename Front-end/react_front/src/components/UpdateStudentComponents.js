import React, { useState } from 'react';
import StudentsService from '../services/StudentsService';
import { useParams, useNavigate  } from 'react-router-dom';
import { useEffect } from 'react';
import { Card } from 'primereact/card';
import { Button } from 'primereact/button';


const AddStudentComplement= () => {
    const [studentId, setStudentId] = useState('')
    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [phoneNumber, setPhoneNumber] = useState('')
    const [cityId, setCityId] = useState('')
    const [districtId, setDistrictId] = useState('')
    const [description, setDescription] = useState('')
    const navigate = useNavigate ();
    const {id} = useParams();

    const navigator = useNavigate()

    const UpdateStudents = (e) =>{
        e.preventDefault();
        const student = {studentId,firstName,lastName,phoneNumber,cityId,districtId,description}

        if(id){
            StudentsService.updateStudent(id,student).then((response)=>{
                console.log(response.data)
                navigate('/students');
            }).catch(error=>{
                console.log(error);
            })
        }
        
    }

    useEffect(() => {
        if (id) {
            
            StudentsService.getStudentById(id)
                .then((response) => {
                    setStudentId(response.data.studentId);
                    setFirstName(response.data.firstName);
                    setLastName(response.data.lastName);
                    setPhoneNumber(response.data.phoneNumber);
                    setCityId(response.data.cityId);
                    setDistrictId(response.data.districtId);
                    setDescription(response.data.description);
                })
                .catch(error => {
                    console.log(error);
                });
        }
    }, []);




  return (
    <div style={{marginTop:'1vh'}}>
        <Card title="Öğrenci bilgilerini güncelle">

        <div className='container' >
            <div className='row'>
                <div >

                    <div >
                        <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Öğrencinin ismi</label>
                            <input
                                type = "text"
                                placeholder='Öğrenci adı'
                                name='firstName'
                                className='form-control'
                                value={firstName}
                                onChange={(e)=> setFirstName(e.target.value)}
                                >
                            </input>
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Öğrencinin soyadı</label>
                            <input
                                type = "text"
                                placeholder='Öğrenci soyadı'
                                name='lastName'
                                className='form-control'
                                value={lastName}
                                onChange={(e)=> setLastName(e.target.value)}
                                >
                            </input>
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Telefon numarası</label>
                            <input
                                type = "text"
                                placeholder='Öğrenci telefon no'
                                name='phoneNumber'
                                className='form-control'
                                value={phoneNumber}
                                onChange={(e)=> setPhoneNumber(e.target.value)}
                                >
                            </input>
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Yaşadiği şehir</label>
                            <input
                                type = "text"
                                placeholder='Şehir no'
                                name='cityId'
                                className='form-control'
                                value={cityId}
                                onChange={(e)=> setCityId(e.target.value)}
                                >
                            </input>
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>İlçe</label>
                            <input
                                type = "text"
                                placeholder='İlçe no'
                                name='districtId'
                                className='form-control'
                                value={districtId}
                                onChange={(e)=> setDistrictId(e.target.value)}
                                >
                            </input>
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Açiklama</label>
                            <input
                                type = "text"
                                placeholder='Açıklama'
                                name='description'
                                className='form-control'
                                value={description}
                                onChange={(e)=> setDescription(e.target.value)}
                                >
                            </input>
                        </div>
                            <Button style={{color:'white'}}label='Öğrenciyi güncelle'onClick={(e)=> UpdateStudents(e) }></Button>
                            <Button style={{color:'white',marginLeft:'1vh'}}label='İptal'onClick={()=> navigator("/students") }></Button>
                        </form>
                        </div>
                    </div>
                </div>
            </div>
        </Card>

    </div>


  )
}

export default AddStudentComplement

