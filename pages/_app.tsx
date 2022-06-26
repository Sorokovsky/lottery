import type { AppProps } from 'next/app';
import React from 'react';
import '../styles/globals.scss';
interface IState {};
class MyApp extends React.Component<AppProps, IState>{
    constructor(props:AppProps){
      super(props);
    }
    render():React.ReactNode {
      let { Component, pageProps } = this.props;
      return(
        <Component {...pageProps}/>
      )
    }
}
export default MyApp;
