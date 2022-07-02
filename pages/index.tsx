import type { NextPage } from 'next';
import { NextRouter, useRouter } from 'next/router';
import React from 'react';
import Container from '../components/Container';
import FileInput from '../components/FileInput';
import MyForm from '../components/MyForm';
import MyInput from '../components/MyInput';
import MySubmit from '../components/MySubmit';
import UserStore from '../store/UserStore';
import { InputType } from '../types/inputType';
const Home:NextPage = ():JSX.Element => {
  const router:NextRouter = useRouter();
  const createLottery = (e:React.FormEvent<HTMLFormElement>):void => {
    e.preventDefault();
    const count:number = +e.currentTarget.count.value;
    UserStore.setCount(count);
    router.push({pathname:'users'});
  }
  return (
   <Container>
    <MyForm submit={createLottery}>
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
