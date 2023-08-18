import React, { useState } from 'react';
import StudentsService from '../services/StudentsService';
import {  useParams, useNavigate  } from 'react-router-dom';
import { useEffect } from 'react';
import 'react-phone-number-input/style.css';
import { Button } from 'primereact/button';
import { Card } from 'primereact/card';

const AddStudentComplement= () => {
    
    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [phoneNumber, setPhoneNumber] = useState('')
    const [cityId, setCityId] = useState('')
    const [districtId, setDistrictId] = useState('')
    const [description, setDescription] = useState('')
    const navigate = useNavigate ();
    const {id} = useParams();

    const navigator = useNavigate()


    const [cities, setCities] = useState([]);
    const [districts, setDistricts] = useState([]);
    

    useEffect(() => {
        StudentsService.getCities()
            .then(response => setCities(response.data))
            .catch(error => console.error('Error axios cities:', error));
    }, []);

   
    useEffect(() => {
        if(cityId!==''){

                StudentsService.getDistrictsByCityId(cityId)
                    .then(response => setDistricts(response.data))
                    .catch(error => console.error('Error axios districts:', error));
        }  
    }, [cityId]);


    const saveOrUpdateStudents = (e) =>{
        e.preventDefault();
        const student = {firstName,lastName,phoneNumber:formatPhoneNumber(phoneNumber)
            ,cityId,districtId,description}

        if(id){
            StudentsService.updateStudent(id,student).then((response)=>{
              
                navigate('/students');
            }).catch(error=>{
                console.log(error);
            })

        }else{
            StudentsService.createStudent(student).then((response)=>{
              
                navigate('/students');
            }).catch(error =>{
                console.log(error)
            })
        }
        
    }

    useEffect(() => {
        if (id) {
            
            StudentsService.getStudentById(id)
                .then((response) => {
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


    const formatPhoneNumber = (input) => {
        const cleaned = ('' + input).replace(/\D/g, '');
    
        const match = cleaned.match(/^(\d{3})(\d{0,3})(\d{0,11})$/);
        if (match) {
            return `${match[1]}${match[2] ? '-' : ''}${match[2]}${match[3] ? '-' : ''}${match[3]}`;
        }
    
        return input;
    };
    
    const formatInput = (value) => {
        return value.replace(/\D/g, '');
    };


    
  return (
    <div style={{marginTop:'1vh'}}>



<Card title="Öğrenci ekle">
<div className='row'>
                <div >
                  
                        <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Öğrencinin ismi</label>
                            <input
                                type = "text"
                                placeholder='Öğrencinin adı'
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
                                placeholder='Öğrencinin soyadı'
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
                                type="text"
                                placeholder='555-123-4567'
                                name='phoneNumber'
                                className='form-control'
                                value={formatPhoneNumber(phoneNumber)}
                                onChange={(e) => setPhoneNumber(formatInput(e.target.value))}
                                />
                            </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Şehir</label>
                            <select
                                className='form-control'
                                value={cityId}
                                onChange={(e) => {
                                setCityId(e.target.value); // Şehir seçimini güncelle
                                }}
                                >
                                <option value=''>Şehir seçin</option>
                                {cities?.map(city => (
                                <option key={city.cityId} value={city.cityId}>
                                {city.cityName}
                                </option>
                                ))}
                                </select>
                                
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>ilçe</label>
                            <select
                                className='form-control'
                                value={districtId}
                                onChange={(e) => {
                                setDistrictId(e.target.value);
                                }}
                            >                             
                            <option value=''>İlçe seçin</option>
                            {districts?.map(districts => (
                                    <option key={districts.districtId} value={districts.districtId}>
                                    {districts.districtName}                                   
                            </option>
                                ))}
                            </select>                               
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Açiklama</label>
                            <input
                                type = "text"
                                placeholder='Açıklama metni'
                                name='description'
                                className='form-control'
                                value={description}
                                onChange={(e)=> setDescription(e.target.value)}
                                >
                            </input>
                        </div>
                            <Button style={{color:'white'}}label='Öğrenci ekle'onClick={(e)=> saveOrUpdateStudents(e) }></Button>
                            <Button style={{color:'white',marginLeft:'1vh'}}label='İptal'onClick={()=> navigator("/students") }></Button>

                            
                            
                        </form>

                    
                </div>
            </div>
</Card>






    

    </div>
  )
}

export default AddStudentComplement

