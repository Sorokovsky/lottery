import { Component, ReactNode } from "react";
import MainLoyout from "../layouts/MainLoyout";
interface IProps {};
interface IState {};
class Index extends Component<IProps, IState> {
    constructor(props: IProps){
      super(props);
      this.state = {};
    }
    render():ReactNode{
      return(
        <MainLoyout title={"Створити лотерею для розіграшу"}>
          
        </MainLoyout>
      )
    }
}
export default Index;