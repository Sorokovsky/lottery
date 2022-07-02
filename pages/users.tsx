import { observer } from "mobx-react-lite";
import { NextPage } from "next";
import { NextRouter, useRouter } from "next/router";
import { useEffect } from "react";
import Container from "../components/Container";
import MyTable from "../components/MyTable";
import UserStore from "../store/UserStore";
const Users:NextPage = observer(():JSX.Element => {
    const router:NextRouter = useRouter()
    useEffect(() => {
        if(UserStore.users.length <= 0){
            router.push('./');
            return;
        }
    }, []);
    return(
        <Container>
           <MyTable />
           <hr />
        </Container>
    )
});
export default Users;