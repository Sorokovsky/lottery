import { observer } from 'mobx-react-lite';
import type { NextPage } from 'next';
import { NextRouter, useRouter } from 'next/router';
import React from 'react';
import Container from '../components/Container';
import FileInput from '../components/FileInput';
import MyForm from '../components/MyForm';
import MyInput from '../components/MyInput';
import MySubmit from '../components/MySubmit';
import SettingsStore from '../store/SettingsStore';
import UserStore from '../store/UserStore';
import { InputType } from '../types/inputType';
const Home:NextPage = observer(():JSX.Element => {
  const router:NextRouter = useRouter();
  const createLottery = (e:React.FormEvent<HTMLFormElement>):void => {
    e.preventDefault();
    const count:number = +e.currentTarget.count.value;
    if(count > 0){
      UserStore.setCount(count);
      router.push({pathname:'users'});
    }else{
      alert(`Оберіть кількість учасників більше 0.`);
    }
  }
  const setBg = (e:React.ChangeEvent<HTMLInputElement>):void => {
    if(e.target.files![0]){
      SettingsStore.setBgImage(e.target.files![0]);
    }
  }
  return (
   <Container>
    <div className="table" style={{height: "auto", padding: "15rem", paddingTop: "15rem"}}>
      <MyForm submit={createLottery}>
        <MyInput type={InputType.NUMBER}
                 placeholder={"Оберіть кількість учасників"}
                 name="count"/>
        <div className='flex'>
          <FileInput change={setBg} accept='image/*' placeholder='Завантажити задній фон' />
          <MySubmit placeholder='Створити лотерею' />
        </div>
      </MyForm>
    </div>
   </Container>
  )
})
export default Home;
