import React, { FC, ReactNode } from 'react';
import cl from '../styles/Container.module.scss';
interface Props{
    children:ReactNode
}
const Container:FC<Props> = ({children}:Props):JSX.Element => {
  return (
    <div className={[cl.container].join(" ")}>{children}</div>
  )
}
export default Container;