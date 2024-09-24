
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PointerservicePointerManager from "./components/listers/PointerservicePointerCards"
import PointerservicePointerDetail from "./components/listers/PointerservicePointerDetail"

import PaymentservicePaymentManager from "./components/listers/PaymentservicePaymentCards"
import PaymentservicePaymentDetail from "./components/listers/PaymentservicePaymentDetail"

import HistoryserviceHistoryManager from "./components/listers/HistoryserviceHistoryCards"
import HistoryserviceHistoryDetail from "./components/listers/HistoryserviceHistoryDetail"

import WebtoonmanagementserviceWebtoonManager from "./components/listers/WebtoonmanagementserviceWebtoonCards"
import WebtoonmanagementserviceWebtoonDetail from "./components/listers/WebtoonmanagementserviceWebtoonDetail"

import PurchaseservicePurchaseManager from "./components/listers/PurchaseservicePurchaseCards"
import PurchaseservicePurchaseDetail from "./components/listers/PurchaseservicePurchaseDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/pointerservices/pointers',
                name: 'PointerservicePointerManager',
                component: PointerservicePointerManager
            },
            {
                path: '/pointerservices/pointers/:id',
                name: 'PointerservicePointerDetail',
                component: PointerservicePointerDetail
            },

            {
                path: '/paymentservices/payments',
                name: 'PaymentservicePaymentManager',
                component: PaymentservicePaymentManager
            },
            {
                path: '/paymentservices/payments/:id',
                name: 'PaymentservicePaymentDetail',
                component: PaymentservicePaymentDetail
            },

            {
                path: '/historyservices/histories',
                name: 'HistoryserviceHistoryManager',
                component: HistoryserviceHistoryManager
            },
            {
                path: '/historyservices/histories/:id',
                name: 'HistoryserviceHistoryDetail',
                component: HistoryserviceHistoryDetail
            },

            {
                path: '/webtoonmanagementservices/webtoons',
                name: 'WebtoonmanagementserviceWebtoonManager',
                component: WebtoonmanagementserviceWebtoonManager
            },
            {
                path: '/webtoonmanagementservices/webtoons/:id',
                name: 'WebtoonmanagementserviceWebtoonDetail',
                component: WebtoonmanagementserviceWebtoonDetail
            },

            {
                path: '/purchaseservices/purchases',
                name: 'PurchaseservicePurchaseManager',
                component: PurchaseservicePurchaseManager
            },
            {
                path: '/purchaseservices/purchases/:id',
                name: 'PurchaseservicePurchaseDetail',
                component: PurchaseservicePurchaseDetail
            },



    ]
})
