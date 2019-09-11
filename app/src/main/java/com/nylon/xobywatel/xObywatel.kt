package com.nylon.xobywatel

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedHelpers.findAndHookMethod
import de.robv.android.xposed.callbacks.XC_LoadPackage

class xObywatel : IXposedHookLoadPackage {

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam?) {
        if (lpparam?.packageName != "pl.nask.mobywatel")
            return

        val identityClass = "pl.nask.android.common.model.Identity"

        findAndHookMethod(
            identityClass,
            lpparam.classLoader,
            "getFirstNames",
            object : XC_MethodHook() {

                override fun afterHookedMethod(param: MethodHookParam?) {
                    super.afterHookedMethod(param)
                    param!!.result = "Jan"
                }
            })

        findAndHookMethod(
            identityClass,
            lpparam.classLoader,
            "getIdNumber",
            object : XC_MethodHook() {

                override fun afterHookedMethod(param: MethodHookParam?) {
                    super.afterHookedMethod(param)

                    param!!.result = "ID 1234"
                }
            })

        findAndHookMethod(
            identityClass,
            lpparam.classLoader,
            "getLastName",
            object : XC_MethodHook() {

                override fun afterHookedMethod(param: MethodHookParam?) {
                    super.afterHookedMethod(param)

                    param!!.result = "Ł. (Bo RODO)"
                }
            })

        findAndHookMethod(
            identityClass,
            lpparam.classLoader,
            "getPesel",
            object : XC_MethodHook() {

                override fun afterHookedMethod(param: MethodHookParam?) {
                    super.afterHookedMethod(param)

                    param!!.result = "1234"
                }
            })

        findAndHookMethod(
            identityClass,
            lpparam.classLoader,
            "getIdIssuingAuthority",
            object : XC_MethodHook() {

                override fun afterHookedMethod(param: MethodHookParam?) {
                    super.afterHookedMethod(param)

                    param!!.result = "PREZYDENT MIASTA BIAŁYSTOK KRZYSZTOF K."
                }
            })

        findAndHookMethod(
            identityClass,
            lpparam.classLoader,
            "getPhoto",
            object : XC_MethodHook() {

                override fun afterHookedMethod(param: MethodHookParam?) {
                    super.afterHookedMethod(param)

                    //Photo in base64
                    param!!.result =
                            "iVBORw0KGgoAAAANSUhEUgAAAOQAAADdCAMAAACc/C7aAAAAbFBMVEUAAAD/ZgD/agD6ZQDwYgD8ZwDfWwDmXgAXCAAlDgAOBQDSVQAqEQD3ZQAiDwAbCwBkKwBBGwBUIgDKUwC2SwDCUQAJAwD/bgAYCQDlXgAeCwCwSQAkDQDyZQDGUgA5FwBbJQAvEwBlKwBGHACLD7lbAAAD6klEQVR4nO2d13LbMBAA1UXJkuWmGnf//z86k4fwLvGRR4AFFHdfgTtgBWGGBQBHIwAAAAAAAACA9Ng/CWTBWhb8MmN0SaIcxwJZsJ5YJSpm3mpvA5EqU1mwNktUzLbV3gaCJJJIpgWSSCKZFkgiiWRaIIkkkmkxbMkMSSSTA0kkkXSxftznPJXXL8n2KrLtVVGnkrX+JVQ2/WA/GclZRKL/s+luIYkkktW7hWTlbEjmIIlkWLfqlbQ73LZkdpzkxF/py2x6JUeXkofPO8GjYF8e/IcbGfOe5/q8S0ZScwzI6oxJRvIgO+ydoDLmxa6GJJJIVgdJCyRzkESyZslRrGRBjLyqnagSW9KOqcZuuRCI5sbzhQ8ZM5YFN6qhr/uct7MrweJDxNzHSE7GTTG1Wz2WR49rXHbeoKTzat2m4FdCEkkkkUQSSSSRrIJqT14Qe+3NmALJo9mOyhahtZotc2ayhdnoNmfj/bnNGNnMUnVhY8WobKsYSbP36k5p7ZNU43UwY+y/3sG+1WpeMguQtH8Y+79b8JIISSSRRBJJJJFEMhif5CngKrpTyWw7E5ijop/yX3Z/OX3onuQlu4tPciw7UHCNbFYrx3mxbWfd+X5uZztzX0zFJ+jRkpdaJe0NaXY1JJFEEkkkkUQSyTJiJQvWoQS0Yy/Bryo5mQpcbf9OaxJSzdmOXatc0reMJGU8I9l1H6NBEskegSSSPQJJJHuE45GkkpxLCtKa1UJK7Gq+bI619VJS3V5czDGemQns+4boO4qo1R+m5HPAEhenpL3ExR6Vgi0TEZIhb7WckiEvfJC8FsnTECQHMZJIXoskcxLJ9iSdT8O7ldwK1Brq01yU/HNVK0rU5tdMxmx9ki3MyejTaZw96HQkG5Qs+L+b1ZD8gb5I9ntOMpJGNSR/oC+SzMkykESyJpzHObcyJ/P9is/PdraV2Nfoq3bZJDOSatG83ZNb36kxmbk4P9H7SUX0iqyBS3b6jKctyUGMJJLXIsmcRBLJtCSj5qR5MmCIpHPXXcjCiKiRfBHniyyUpLmZcjba/MzqTffEqLZR2yzVXsil1c04SSfm1bpmXL2a84jLFiS7OXRIEjUn+yI5iJFE8lokmZNIIpmWJHMSyUDJ8zKK87kHkvEvRnxvBhRtz8kmv6tl0ruRRNJgEJLMyXpAsjJIGjAn62EQkq19SdSkGcnD+0POe3OS0y/RzoMZ08yc3JjrUOqVdB7c3sxIhrzwcdL6qzsTJONo/f2kSWKSgxhJJINJTJI5GQyScfRBsuBDoD5CDolWc7K2rzFebixeY1OvzdSPZkwmvzBvVwMAAAAAAAAAAOgb3068h6zOpAi3AAAAAElFTkSuQmCC"
                }
            })

        findAndHookMethod(
            "pl.nask.android.common.k", lpparam.classLoader, "c", Any::class.java, object : XC_MethodHook() {

                override fun afterHookedMethod(param: MethodHookParam?) {
                    super.afterHookedMethod(param)

                    param!!.result = "01.01.2077"
                }
            })
    }
}