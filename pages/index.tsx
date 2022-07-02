import type { NextPage } from 'next';
import React from 'react';
import Container from '../components/Container';
import FileInput from '../components/FileInput';
import MyForm from '../components/MyForm';
import MyInput from '../components/MyInput';
import MySubmit from '../components/MySubmit';
import { InputType } from '../types/inputType';
const Home:NextPage = ():JSX.Element => {
  const createLottery = (e:React.FormEvent<HTMLFormElement>) => {
  }
  return (
   <Container>
    <MyForm>
      <MyInput type={InputType.NUMBER} 
               placeholder={"Оберіть кількість учасників"}
               name="count"/>
      <div className='flex'>
        <FileInput placeholder='Завантажити задній фон' />
        <MySubmit placeholder='Створити лотерею' />
      </div>
    </MyForm>
   </Container>
  )
}
export default Home;
