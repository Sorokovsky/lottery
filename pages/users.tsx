import { NextPage } from "next";
import Container from "../components/Container";
import MyTable from "../components/MyTable";
const Users:NextPage = ():JSX.Element => {
    return(
        <Container>
           <MyTable />
        </Container>
    )
}
export default Users;