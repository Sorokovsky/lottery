import { Component } from "react";
import cl from "../styles/MyInput.module.scss";
interface IProps{
    type?: string;
    name?: string;
    placeholder?: string;
    id?:string;
    classes?: string;
};
interface IState{}
class MyInput extends Component<IProps, IState>{
    constructor(props: IProps){
        super(props);
    }
    render():JSX.Element{
        return(
            <input className={[cl.input, this.props.classes].join(" ")}
            type={this.props.type ? this.props.type : 'text'} 
            name={this.props.name ? this.props.name : ''}
            placeholder={this.props.placeholder ? this.props.placeholder : ''}
            id={this.props.id ? this.props.id : ''}/>
        )
    }
}
export default MyInput;