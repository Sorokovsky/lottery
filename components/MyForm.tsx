import React, { FC, ReactNode } from 'react';
import { methods } from '../types/methods';
interface Props{
    children:ReactNode;
    action?:string;
    method?:methods;
};
const MyForm:FC<Props> = ({children, action = '#', method = methods.GET}:Props):JSX.Element => {
  return (
    <form action={action} method={method}>
        {children}
    </form>
  )
}
export default MyForm;