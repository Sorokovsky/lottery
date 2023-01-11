/** @type {import('next').NextConfig} */
const WithPWA = require('next-pwa');
const nextConfig = WithPWA({
  pwa: {
    dest: 'public',
    disable: process.env.NODE_ENV === 'development'
  },
  reactStrictMode: true,
})
module.exports = nextConfig
