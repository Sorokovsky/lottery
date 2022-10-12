import { observer } from "mobx-react-lite";
import { NextPage } from "next";
import { NextRouter, useRouter } from "next/router";
import { Fragment, useEffect } from "react";
import Container from "../components/Container";
import MyPopub from "../components/MyPopub";
import MyTable from "../components/MyTable";
import SettingsStore from "../store/SettingsStore";
import UserStore from "../store/UserStore";
const Users:NextPage = observer(():JSX.Element => {
    const router:NextRouter = useRouter()
    useEffect(() => {
        if(UserStore.users.length <= 0){
            router.push('/');
        }
    }, []);
    const close = ():void => {
        router.push('/');
    }
    return(
        <Fragment>
            <MyPopub />
            <p className="text" onClick={()=>{
                SettingsStore.popubIsOpen = true;
            }}>TEXT</p>
            <div onClick={close} className="close">+</div>
            <Container>
            
               <MyTable />
            </Container>
        </Fragment>
    )
});
export default Users;