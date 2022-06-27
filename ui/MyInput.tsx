import { Component } from "react";
interface IProps{
    type?: string;
    name?: string;
};
interface IState{}
class MyInput extends Component<IProps, IState>{
    constructor(props: IProps){
        super(props);
    }
    render():JSX.Element {
        return(
            <input type={this.props.type ? this.props.type : 'text'} 
            name={this.props.name ? this.props.name : ''}/>
        )
    }
}
export default MyInput;