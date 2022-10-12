import { observer } from "mobx-react-lite";
import React, { FC, useRef, useState, } from "react";
import UserStore from "../store/UserStore";
import { UserType } from "../types/UserType";
import Randomize from "./Randomize";
const MyTable:FC = observer(():JSX.Element => {
    const [isOpen, setIsOpen] = useState<boolean>(true);
    const clickHandler = ():void => setIsOpen(!isOpen);
    return (
        <div className="table">
            <div className={[isOpen ? "open": "", 'users'].join(" ")}>
            <div onClick={clickHandler} className={["cl", !isOpen ? "toopen": ""].join(" ")}>+</div>
                <table>

                    {UserStore.users.length ? UserStore.users.map((user:UserType,
                        index:number) =>
                    <tr key={index}>
                        <td>
                            <span>{index + 1}.</span>
                            <div>
                                <input
                                type="text"
                                value={user.name}
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
            </div>
            <div className="rand">
                <Randomize />
            </div>
        </div>
    )
})
export default MyTable;