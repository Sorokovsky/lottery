import React, { FC, ReactNode } from 'react';
import { methods } from '../types/methods';
interface Props{
    children:ReactNode;
    action?:string;
    method?:methods;
    submit?:(e:React.FormEvent<HTMLFormElement>) => void;
};
const MyForm:FC<Props> = (
  {children,
  action = '#', 
  method = methods.GET,
  submit = (e) => {e.preventDefault();}
  }:Props):JSX.Element => {
  return (
    <form onSubmit={submit} action={action} method={method}>
        {children}
    </form>
  )
}
export default MyForm;