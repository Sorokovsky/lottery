import { observer } from "mobx-react-lite";
import React, { FC, } from "react";
import UserStore from "../store/UserStore";
import { UserType } from "../types/UserType";
const MyTable:FC = observer(():JSX.Element => {
    
    return (
        <table>{UserStore.users.length ? UserStore.users.map((user:UserType, 
                index:number) => <tr key={index}>
                <td>
                    <span>{index + 1}.</span>
                    <div>
                        <input 
                        type="text" 
                        placeholder={user.name}
                        onChange={(e:React.ChangeEvent<HTMLInputElement>):void => {
                            UserStore.changeUser(e.target.value, index);
                        }}
                        />
                    </div>
                    </td>
            </tr>) 
            : ''}
            <tr>
                <td>
                    <a href="#" onClick={(e:React.MouseEvent<HTMLAnchorElement>):void => {
                        e.preventDefault();
                        UserStore.addUser({name: ""});
                    }}>+</a>
                </td>
            </tr>
        </table>
    )
})
export default MyTable;