import '../styles/globals.scss';
import type { AppProps } from 'next/app';
import Head from 'next/head';
const MyApp = ({ Component, pageProps }: AppProps):JSX.Element => {
  return (
    <>
    <Head>
      <title>Розіграж</title>
    </Head>
    <Component {...pageProps} />
    </>
    )
}
export default MyApp;