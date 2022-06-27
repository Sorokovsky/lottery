import { Component } from "react";
interface IProps{};
interface IState{};
class MyForm extends Component<IProps, IState>{
    constructor(props: IProps){
        super(props);
    }
    render():JSX.Element{
        return(
            <form action="#">
                
            </form>
        );
    }
}
export default MyForm;