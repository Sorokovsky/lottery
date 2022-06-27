import { Component } from "react";
import MyContainer from "../component/MyContainer";
import MyForm from "../component/MyForm";
import MainLoyout from "../layouts/MainLoyout";
import MyInput from "../ui/MyInput";
import cl from "../styles/Home.module.scss";
interface IProps {};
interface IState {};
class Index extends Component<IProps, IState> {
    constructor(props: IProps){
      super(props);
      this.state = {};
    }
    render():JSX.Element{
      return(
        <MainLoyout title={"Створити лотерею для розіграшу"}>
          <MyContainer>
            <MyForm>
              <label htmlFor="count">Кільксть учасників</label>
              <MyInput 
              type="number" 
              id="count" 
              placeholder="Введіть кількість учасників"
              />
              <MyInput type="file" classes={[cl.file].join(" ")} id="bg" name="bg"/>
              <label htmlFor="bg">Оберіть задній фон розіграшу</label>
            </MyForm>
          </MyContainer>
        </MainLoyout>
      )
    }
}
export default Index;