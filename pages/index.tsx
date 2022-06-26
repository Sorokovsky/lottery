import { Component } from "react";
interface IProps {
  t:string;
};
interface IState {};
class Index extends Component<IProps, IState> {
    constructor(props: IProps){
      super(props);
      this.state = {};
    }
    render():JSX.Element{
      return(
        <>
        Hello
        </>
      )
    }
}
export default Index;