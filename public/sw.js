if(!self.define){let e,s={};const n=(n,i)=>(n=new URL(n+".js",i).href,s[n]||new Promise((s=>{if("document"in self){const e=document.createElement("script");e.src=n,e.onload=s,document.head.appendChild(e)}else e=n,importScripts(n),s()})).then((()=>{let e=s[n];if(!e)throw new Error(`Module ${n} didn’t register its module`);return e})));self.define=(i,c)=>{const a=e||("document"in self?document.currentScript.src:"")||location.href;if(s[a])return;let t={};const o=e=>n(e,a),r={module:{uri:a},exports:t,require:o};s[a]=Promise.all(i.map((e=>r[e]||o(e)))).then((e=>(c(...e),t)))}}define(["./workbox-588899ac"],(function(e){"use strict";importScripts(),self.skipWaiting(),e.clientsClaim(),e.precacheAndRoute([{url:"/_next/static/UA3VQZ3ZS2MyzGqW4hWry/_buildManifest.js",revision:"0fc734ff5933d62ded5f869a9c376e7d"},{url:"/_next/static/UA3VQZ3ZS2MyzGqW4hWry/_ssgManifest.js",revision:"b6652df95db52feb4daf4eca35380933"},{url:"/_next/static/chunks/85-b8ed0ce74ff5e4e0.js",revision:"b8ed0ce74ff5e4e0"},{url:"/_next/static/chunks/e82996df-8131e5af5ea8f001.js",revision:"8131e5af5ea8f001"},{url:"/_next/static/chunks/framework-4556c45dd113b893.js",revision:"4556c45dd113b893"},{url:"/_next/static/chunks/main-572b913902beb9f3.js",revision:"572b913902beb9f3"},{url:"/_next/static/chunks/pages/_app-9e2fd71f74f366c1.js",revision:"9e2fd71f74f366c1"},{url:"/_next/static/chunks/pages/_error-a4ba2246ff8fb532.js",revision:"a4ba2246ff8fb532"},{url:"/_next/static/chunks/pages/index-b18388eb185c1b6c.js",revision:"b18388eb185c1b6c"},{url:"/_next/static/chunks/pages/users-3423f5ce742fd713.js",revision:"3423f5ce742fd713"},{url:"/_next/static/chunks/polyfills-0d1b80a048d4787e.js",revision:"40ccea369337cec877151c906f22814d"},{url:"/_next/static/chunks/webpack-9b312e20a4e32339.js",revision:"9b312e20a4e32339"},{url:"/_next/static/css/1471f7b9f223b43a.css",revision:"1471f7b9f223b43a"},{url:"/_next/static/css/29770ba0bdcef8e1.css",revision:"29770ba0bdcef8e1"},{url:"/_next/static/css/a9d3534f148f7010.css",revision:"a9d3534f148f7010"},{url:"/icons/icon-128x128.png",revision:"74507ebe7aa5f3917c2d263f82511518"},{url:"/icons/icon-128x128.webp",revision:"20532fef201df7c9f31ed3af172f72ad"},{url:"/icons/icon-144x144.png",revision:"4c6462b1493f1b3c592e7210ce3a8093"},{url:"/icons/icon-144x144.webp",revision:"58f2fcb0aa511bed41223e1a69b9bac7"},{url:"/icons/icon-152x152.png",revision:"b9d590c8648a401cedcf7c8a914eea04"},{url:"/icons/icon-152x152.webp",revision:"94ee4b0c5a45dc2bb08344df1e30f9c7"},{url:"/icons/icon-192x192.png",revision:"f103f73d3235c6a594cdb990500de358"},{url:"/icons/icon-192x192.webp",revision:"87369e21bf1092e9f15b1998be322475"},{url:"/icons/icon-384x384.png",revision:"ed48401e6572f2545575637c5a575874"},{url:"/icons/icon-384x384.webp",revision:"7d59fce98578aa6f15c91c52385dbef2"},{url:"/icons/icon-48x48.png",revision:"a71847a09830127cd5cffd7ea68851e8"},{url:"/icons/icon-48x48.webp",revision:"812d0db3bd0d8dd993c7a78071e4ac7e"},{url:"/icons/icon-512x512.png",revision:"0f0a9d8401a67d0baac199ac8d17fb07"},{url:"/icons/icon-512x512.webp",revision:"9f4e42f9b0eb407da3de0ad3fd15df55"},{url:"/icons/icon-72x72.png",revision:"fd5893cb05392f163a89ce02ecbf0bdb"},{url:"/icons/icon-72x72.webp",revision:"6be0bf2d7107a9dd9d94d8678810bdad"},{url:"/icons/icon-96x96.png",revision:"dff9258bb712e6b5509a8eeb6c52b8c3"},{url:"/icons/icon-96x96.webp",revision:"a1b6f7580026e2085aca366db5913b50"},{url:"/manifest.json",revision:"bb59dd7d4f299bbe3689013be1057915"}],{ignoreURLParametersMatching:[]}),e.cleanupOutdatedCaches(),e.registerRoute("/",new e.NetworkFirst({cacheName:"start-url",plugins:[{cacheWillUpdate:async({request:e,response:s,event:n,state:i})=>s&&"opaqueredirect"===s.type?new Response(s.body,{status:200,statusText:"OK",headers:s.headers}):s}]}),"GET"),e.registerRoute(/^https:\/\/fonts\.(?:gstatic)\.com\/.*/i,new e.CacheFirst({cacheName:"google-fonts-webfonts",plugins:[new e.ExpirationPlugin({maxEntries:4,maxAgeSeconds:31536e3})]}),"GET"),e.registerRoute(/^https:\/\/fonts\.(?:googleapis)\.com\/.*/i,new e.StaleWhileRevalidate({cacheName:"google-fonts-stylesheets",plugins:[new e.ExpirationPlugin({maxEntries:4,maxAgeSeconds:604800})]}),"GET"),e.registerRoute(/\.(?:eot|otf|ttc|ttf|woff|woff2|font.css)$/i,new e.StaleWhileRevalidate({cacheName:"static-font-assets",plugins:[new e.ExpirationPlugin({maxEntries:4,maxAgeSeconds:604800})]}),"GET"),e.registerRoute(/\.(?:jpg|jpeg|gif|png|svg|ico|webp)$/i,new e.StaleWhileRevalidate({cacheName:"static-image-assets",plugins:[new e.ExpirationPlugin({maxEntries:64,maxAgeSeconds:86400})]}),"GET"),e.registerRoute(/\/_next\/image\?url=.+$/i,new e.StaleWhileRevalidate({cacheName:"next-image",plugins:[new e.ExpirationPlugin({maxEntries:64,maxAgeSeconds:86400})]}),"GET"),e.registerRoute(/\.(?:mp3|wav|ogg)$/i,new e.CacheFirst({cacheName:"static-audio-assets",plugins:[new e.RangeRequestsPlugin,new e.ExpirationPlugin({maxEntries:32,maxAgeSeconds:86400})]}),"GET"),e.registerRoute(/\.(?:mp4)$/i,new e.CacheFirst({cacheName:"static-video-assets",plugins:[new e.RangeRequestsPlugin,new e.ExpirationPlugin({maxEntries:32,maxAgeSeconds:86400})]}),"GET"),e.registerRoute(/\.(?:js)$/i,new e.StaleWhileRevalidate({cacheName:"static-js-assets",plugins:[new e.ExpirationPlugin({maxEntries:32,maxAgeSeconds:86400})]}),"GET"),e.registerRoute(/\.(?:css|less)$/i,new e.StaleWhileRevalidate({cacheName:"static-style-assets",plugins:[new e.ExpirationPlugin({maxEntries:32,maxAgeSeconds:86400})]}),"GET"),e.registerRoute(/\/_next\/data\/.+\/.+\.json$/i,new e.StaleWhileRevalidate({cacheName:"next-data",plugins:[new e.ExpirationPlugin({maxEntries:32,maxAgeSeconds:86400})]}),"GET"),e.registerRoute(/\.(?:json|xml|csv)$/i,new e.NetworkFirst({cacheName:"static-data-assets",plugins:[new e.ExpirationPlugin({maxEntries:32,maxAgeSeconds:86400})]}),"GET"),e.registerRoute((({url:e})=>{if(!(self.origin===e.origin))return!1;const s=e.pathname;return!s.startsWith("/api/auth/")&&!!s.startsWith("/api/")}),new e.NetworkFirst({cacheName:"apis",networkTimeoutSeconds:10,plugins:[new e.ExpirationPlugin({maxEntries:16,maxAgeSeconds:86400})]}),"GET"),e.registerRoute((({url:e})=>{if(!(self.origin===e.origin))return!1;return!e.pathname.startsWith("/api/")}),new e.NetworkFirst({cacheName:"others",networkTimeoutSeconds:10,plugins:[new e.ExpirationPlugin({maxEntries:32,maxAgeSeconds:86400})]}),"GET"),e.registerRoute((({url:e})=>!(self.origin===e.origin)),new e.NetworkFirst({cacheName:"cross-origin",networkTimeoutSeconds:10,plugins:[new e.ExpirationPlugin({maxEntries:32,maxAgeSeconds:3600})]}),"GET")}));