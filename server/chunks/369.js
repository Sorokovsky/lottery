exports.id = 369;
exports.ids = [369];
exports.modules = {

/***/ 521:
/***/ ((module) => {

// Exports
module.exports = {
	"container": "Container_container__1Pm77"
};


/***/ }),

/***/ 284:
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

"use strict";
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   "Z": () => (__WEBPACK_DEFAULT_EXPORT__)
/* harmony export */ });
/* harmony import */ var react_jsx_runtime__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(997);
/* harmony import */ var react_jsx_runtime__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react_jsx_runtime__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(689);
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var _styles_Container_module_scss__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(521);
/* harmony import */ var _styles_Container_module_scss__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(_styles_Container_module_scss__WEBPACK_IMPORTED_MODULE_2__);



const Container = ({ children  })=>{
    return /*#__PURE__*/ react_jsx_runtime__WEBPACK_IMPORTED_MODULE_0__.jsx("div", {
        className: [
            (_styles_Container_module_scss__WEBPACK_IMPORTED_MODULE_2___default().container)
        ].join(" "),
        children: children
    });
};
/* harmony default export */ const __WEBPACK_DEFAULT_EXPORT__ = (Container);


/***/ }),

/***/ 357:
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

"use strict";

// EXPORTS
__webpack_require__.d(__webpack_exports__, {
  "Z": () => (/* binding */ store_UserStore)
});

// EXTERNAL MODULE: external "mobx"
var external_mobx_ = __webpack_require__(211);
;// CONCATENATED MODULE: ./hooks/useRandom.ts
const useRandom = (min, max)=>{
    return Math.floor(Math.random() * (max - min + 1) + min);
};

;// CONCATENATED MODULE: ./store/UserStore.ts


class UserStore {
    users = [];
    constructor(){
        (0,external_mobx_.makeAutoObservable)(this);
    }
    addUser(user) {
        this.users.push(user);
    }
    removeUser() {
        this.users.pop();
    }
    randomizeUser() {
        const index = useRandom(0, this.users.length - 1);
        return `${index + 1}. ${this.users[index].name}`;
    }
    changeUser(name, index) {
        this.users[index].name = name;
    }
    setCount(length) {
        this.users.length = length;
        for(let index = 0; index < this.users.length; index++){
            this.users[index] = {
                name: ""
            };
        }
    }
}
/* harmony default export */ const store_UserStore = (new UserStore());


/***/ })

};
;