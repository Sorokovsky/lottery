import { Component } from "react";
interface IProps{
    type?: string;
    name?: string;
    placeholder?: string;
};
interface IState{}
class MyInput extends Component<IProps, IState>{
    constructor(props: IProps){
        super(props);
    }
    render():JSX.Element{
        return(
            <input type={this.props.type ? this.props.type : 'text'} 
            name={this.props.name ? this.props.name : ''}
            placeholder={this.props.placeholder ? this.props.placeholder : ''}/>
        )
    }
}
export default MyInput;