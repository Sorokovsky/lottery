import type { NextPage } from 'next';
import Container from '../components/Container';
import FileInput from '../components/FileInput';
import MyForm from '../components/MyForm';
import MyInput from '../components/MyInput';
import { InputType } from '../types/inputType';
const Home:NextPage = ():JSX.Element => {
  return (
   <Container>
    <MyForm>
      <MyInput type={InputType.NUMBER} 
               placeholder={"Оберіть кількість учасників"}
               name="count"/>
      <div className='flex'>
        <FileInput placeholder='Завантажити задній фон' />
      </div>
    </MyForm>
   </Container>
  )
}
export default Home;
