import { Component, ReactNode } from "react";
import cl from '../styles/MyContainer.module.scss';
interface IProps{
    children: ReactNode;
};
interface IState{};
class MyContainer extends Component<IProps, IState>{
    constructor(props: IProps){
        super(props);
    }
    render():JSX.Element{
        return(
            <div className={[cl.container].join(" ")}>
                {this.props.children}
            </div>
        )
    }
}
export default MyContainer;