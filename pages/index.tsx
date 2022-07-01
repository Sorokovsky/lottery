import type { NextPage } from 'next';
import Container from '../components/Container';
import MyForm from '../components/MyForm';
import MyInput from '../components/MyInput';
import { InputType } from '../types/inputType';
const Home: NextPage = () => {
  return (
   <Container>
    <MyForm>
      <MyInput type={InputType.NUMBER} 
               placeholder={"Оберіть кількість учасників"}
               name="count"/>
    </MyForm>
   </Container>
  )
}
export default Home;
