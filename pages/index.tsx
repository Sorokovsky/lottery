import { Component, ReactNode } from "react";
interface IProps {};
interface IState {};
class Index extends Component<IProps, IState> {
    constructor(props: IProps){
      super(props);
      this.state = {};
    }
    render():ReactNode{
      return(
        <h1>he</h1>
      )
    }
}
export default Index;