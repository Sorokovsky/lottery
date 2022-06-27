import Head from "next/head";
import { Component, ReactNode, Fragment } from "react";
import cl from '../styles/MainLoyout.module.scss';
interface IProps{
    title:string;
    description?:string;
    keywords?:Array<string>,
    children:ReactNode;
};
interface IState{};
class MainLoyout extends Component<IProps, IState>{
    constructor(props: IProps){
        super(props);
    }
    render():ReactNode{
        return(
            <Fragment>
                <Head>
                    <title>{this.props.title}</title>
                    <meta name="description" content={this.props.description} />
                    <meta name="keywords" content={this.props.keywords ? this.props.keywords.join(",") : ""}/>
                </Head>
                <div className={[cl.wrapper].join(" ")}>
                    <main className={[cl.main].join(" ")}>
                        {this.props.children}
                    </main>
                </div>
            </Fragment>
        )
    }
}
export default MainLoyout;