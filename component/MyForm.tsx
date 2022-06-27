import { Component, ReactNode } from "react";
interface IProps{
    children: ReactNode;
};
interface IState{};
class MyForm extends Component<IProps, IState>{
    constructor(props: IProps){
        super(props);
    }
    render():JSX.Element{
        return(
            <form action="#">
                {this.props.children}
            </form>
        );
    }
}
export default MyForm;