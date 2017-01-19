typeof $style === 'function' && $style(getDistPath() + 'plugin/ztree/ztree.css');
(function (p) {
    var G, H, I, J, K, L, r = {}, u = {}, v = {}, M = {
            treeId: "",
            treeObj: null,
            view: {
                addDiyDom: null,
                autoCancelSelected: !0,
                dblClickExpand: !0,
                expandSpeed: "fast",
                fontCss: {},
                nameIsHTML: !1,
                selectedMulti: !0,
                showIcon: !0,
                showLine: !0,
                showTitle: !0,
                txtSelectedEnable: !1
            },
            data: {
                key: {children: "children", name: "name", title: "", url: "url"},
                simpleData: {enable: !1, idKey: "id", pIdKey: "pId", rootPId: null},
                keep: {parent: !1, leaf: !1}
            },
            async: {
                enable: !1,
                contentType: "application/x-www-form-urlencoded",
                type: "post",
                dataType: "text",
                url: "",
                autoParam: [],
                otherParam: [],
                dataFilter: null
            },
            callback: {
                beforeAsync: null,
                beforeClick: null,
                beforeDblClick: null,
                beforeRightClick: null,
                beforeMouseDown: null,
                beforeMouseUp: null,
                beforeExpand: null,
                beforeCollapse: null,
                beforeRemove: null,
                onAsyncError: null,
                onAsyncSuccess: null,
                onNodeCreated: null,
                onClick: null,
                onDblClick: null,
                onRightClick: null,
                onMouseDown: null,
                onMouseUp: null,
                onExpand: null,
                onCollapse: null,
                onRemove: null
            }
        }, w = [function (b) {
            var a = b.treeObj, c = e.event;
            a.bind(c.NODECREATED, function (a, c, g) {
                j.apply(b.callback.onNodeCreated,
                    [a, c, g])
            });
            a.bind(c.CLICK, function (a, c, g, l, h) {
                j.apply(b.callback.onClick, [c, g, l, h])
            });
            a.bind(c.EXPAND, function (a, c, g) {
                j.apply(b.callback.onExpand, [a, c, g])
            });
            a.bind(c.COLLAPSE, function (a, c, g) {
                j.apply(b.callback.onCollapse, [a, c, g])
            });
            a.bind(c.ASYNC_SUCCESS, function (a, c, g, l) {
                j.apply(b.callback.onAsyncSuccess, [a, c, g, l])
            });
            a.bind(c.ASYNC_ERROR, function (a, c, g, l, h, e) {
                j.apply(b.callback.onAsyncError, [a, c, g, l, h, e])
            })
        }], x = [function (b) {
            var a = e.event;
            b.treeObj.unbind(a.NODECREATED).unbind(a.CLICK).unbind(a.EXPAND).unbind(a.COLLAPSE).unbind(a.ASYNC_SUCCESS).unbind(a.ASYNC_ERROR)
        }],
        y = [function (b) {
            var a = h.getCache(b);
            a || (a = {}, h.setCache(b, a));
            a.nodes = [];
            a.doms = []
        }], z = [function (b, a, c, d, f, g) {
            if (c) {
                var l = h.getRoot(b), e = b.data.key.children;
                c.level = a;
                c.tId = b.treeId + "_" + ++l.zId;
                c.parentTId = d ? d.tId : null;
                c.open = typeof c.open == "string" ? j.eqs(c.open, "true") : !!c.open;
                c[e] && c[e].length > 0 ? (c.isParent = !0, c.zAsync = !0) : (c.isParent = typeof c.isParent == "string" ? j.eqs(c.isParent, "true") : !!c.isParent, c.open = c.isParent && !b.async.enable ? c.open : !1, c.zAsync = !c.isParent);
                c.isFirstNode = f;
                c.isLastNode =
                    g;
                c.getParentNode = function () {
                    return h.getNodeCache(b, c.parentTId)
                };
                c.getPreNode = function () {
                    return h.getPreNode(b, c)
                };
                c.getNextNode = function () {
                    return h.getNextNode(b, c)
                };
                c.isAjaxing = !1;
                h.fixPIdKeyValue(b, c)
            }
        }], s = [function (b) {
            var a = b.target, c = h.getSetting(b.data.treeId), d = "", f = null, g = "", l = "", i = null, n = null, k = null;
            if (j.eqs(b.type, "mousedown")) l = "mousedown"; else if (j.eqs(b.type, "mouseup")) l = "mouseup"; else if (j.eqs(b.type, "contextmenu")) l = "contextmenu"; else if (j.eqs(b.type, "click"))if (j.eqs(a.tagName, "span") &&
                a.getAttribute("treeNode" + e.id.SWITCH) !== null) d = j.getNodeMainDom(a).id, g = "switchNode"; else {
                if (k = j.getMDom(c, a, [{
                        tagName: "a",
                        attrName: "treeNode" + e.id.A
                    }])) d = j.getNodeMainDom(k).id, g = "clickNode"
            } else if (j.eqs(b.type, "dblclick") && (l = "dblclick", k = j.getMDom(c, a, [{
                    tagName: "a",
                    attrName: "treeNode" + e.id.A
                }]))) d = j.getNodeMainDom(k).id, g = "switchNode";
            if (l.length > 0 && d.length == 0 && (k = j.getMDom(c, a, [{
                    tagName: "a",
                    attrName: "treeNode" + e.id.A
                }]))) d = j.getNodeMainDom(k).id;
            if (d.length > 0)switch (f = h.getNodeCache(c, d), g) {
                case "switchNode":
                    f.isParent ?
                        j.eqs(b.type, "click") || j.eqs(b.type, "dblclick") && j.apply(c.view.dblClickExpand, [c.treeId, f], c.view.dblClickExpand) ? i = G : g = "" : g = "";
                    break;
                case "clickNode":
                    i = H
            }
            switch (l) {
                case "mousedown":
                    n = I;
                    break;
                case "mouseup":
                    n = J;
                    break;
                case "dblclick":
                    n = K;
                    break;
                case "contextmenu":
                    n = L
            }
            return {stop: !1, node: f, nodeEventType: g, nodeEventCallback: i, treeEventType: l, treeEventCallback: n}
        }], A = [function (b) {
            var a = h.getRoot(b);
            a || (a = {}, h.setRoot(b, a));
            a[b.data.key.children] = [];
            a.expandTriggerFlag = !1;
            a.curSelectedList = [];
            a.noSelection = !0;
            a.createdNodes = [];
            a.zId = 0;
            a._ver = (new Date).getTime()
        }], B = [], C = [], D = [], E = [], F = [], h = {
            addNodeCache: function (b, a) {
                h.getCache(b).nodes[h.getNodeCacheId(a.tId)] = a
            }, getNodeCacheId: function (b) {
                return b.substring(b.lastIndexOf("_") + 1)
            }, addAfterA: function (b) {
                C.push(b)
            }, addBeforeA: function (b) {
                B.push(b)
            }, addInnerAfterA: function (b) {
                E.push(b)
            }, addInnerBeforeA: function (b) {
                D.push(b)
            }, addInitBind: function (b) {
                w.push(b)
            }, addInitUnBind: function (b) {
                x.push(b)
            }, addInitCache: function (b) {
                y.push(b)
            }, addInitNode: function (b) {
                z.push(b)
            },
            addInitProxy: function (b, a) {
                a ? s.splice(0, 0, b) : s.push(b)
            }, addInitRoot: function (b) {
                A.push(b)
            }, addNodesData: function (b, a, c) {
                var d = b.data.key.children;
                a[d] || (a[d] = []);
                if (a[d].length > 0) a[d][a[d].length - 1].isLastNode = !1, i.setNodeLineIcos(b, a[d][a[d].length - 1]);
                a.isParent = !0;
                a[d] = a[d].concat(c)
            }, addSelectedNode: function (b, a) {
                var c = h.getRoot(b);
                h.isSelectedNode(b, a) || c.curSelectedList.push(a)
            }, addCreatedNode: function (b, a) {
                (b.callback.onNodeCreated || b.view.addDiyDom) && h.getRoot(b).createdNodes.push(a)
            }, addZTreeTools: function (b) {
                F.push(b)
            },
            exSetting: function (b) {
                p.extend(!0, M, b)
            }, fixPIdKeyValue: function (b, a) {
                b.data.simpleData.enable && (a[b.data.simpleData.pIdKey] = a.parentTId ? a.getParentNode()[b.data.simpleData.idKey] : b.data.simpleData.rootPId)
            }, getAfterA: function (b, a, c) {
                for (var d = 0, f = C.length; d < f; d++)C[d].apply(this, arguments)
            }, getBeforeA: function (b, a, c) {
                for (var d = 0, f = B.length; d < f; d++)B[d].apply(this, arguments)
            }, getInnerAfterA: function (b, a, c) {
                for (var d = 0, f = E.length; d < f; d++)E[d].apply(this, arguments)
            }, getInnerBeforeA: function (b, a, c) {
                for (var d =
                    0, f = D.length; d < f; d++)D[d].apply(this, arguments)
            }, getCache: function (b) {
                return v[b.treeId]
            }, getNextNode: function (b, a) {
                if (!a)return null;
                for (var c = b.data.key.children, d = a.parentTId ? a.getParentNode() : h.getRoot(b), f = 0, g = d[c].length - 1; f <= g; f++)if (d[c][f] === a)return f == g ? null : d[c][f + 1];
                return null
            }, getNodeByParam: function (b, a, c, d) {
                if (!a || !c)return null;
                for (var f = b.data.key.children, g = 0, l = a.length; g < l; g++) {
                    if (a[g][c] == d)return a[g];
                    var e = h.getNodeByParam(b, a[g][f], c, d);
                    if (e)return e
                }
                return null
            }, getNodeCache: function (b,
                                       a) {
                if (!a)return null;
                var c = v[b.treeId].nodes[h.getNodeCacheId(a)];
                return c ? c : null
            }, getNodeName: function (b, a) {
                return "" + a[b.data.key.name]
            }, getNodeTitle: function (b, a) {
                return "" + a[b.data.key.title === "" ? b.data.key.name : b.data.key.title]
            }, getNodes: function (b) {
                return h.getRoot(b)[b.data.key.children]
            }, getNodesByParam: function (b, a, c, d) {
                if (!a || !c)return [];
                for (var f = b.data.key.children, g = [], l = 0, e = a.length; l < e; l++)a[l][c] == d && g.push(a[l]), g = g.concat(h.getNodesByParam(b, a[l][f], c, d));
                return g
            }, getNodesByParamFuzzy: function (b,
                                               a, c, d) {
                if (!a || !c)return [];
                for (var f = b.data.key.children, g = [], d = d.toLowerCase(), l = 0, e = a.length; l < e; l++)typeof a[l][c] == "string" && a[l][c].toLowerCase().indexOf(d) > -1 && g.push(a[l]), g = g.concat(h.getNodesByParamFuzzy(b, a[l][f], c, d));
                return g
            }, getNodesByFilter: function (b, a, c, d, f) {
                if (!a)return d ? null : [];
                for (var g = b.data.key.children, e = d ? null : [], i = 0, n = a.length; i < n; i++) {
                    if (j.apply(c, [a[i], f], !1)) {
                        if (d)return a[i];
                        e.push(a[i])
                    }
                    var k = h.getNodesByFilter(b, a[i][g], c, d, f);
                    if (d && k)return k;
                    e = d ? k : e.concat(k)
                }
                return e
            },
            getPreNode: function (b, a) {
                if (!a)return null;
                for (var c = b.data.key.children, d = a.parentTId ? a.getParentNode() : h.getRoot(b), f = 0, g = d[c].length; f < g; f++)if (d[c][f] === a)return f == 0 ? null : d[c][f - 1];
                return null
            }, getRoot: function (b) {
                return b ? u[b.treeId] : null
            }, getRoots: function () {
                return u
            }, getSetting: function (b) {
                return r[b]
            }, getSettings: function () {
                return r
            }, getZTreeTools: function (b) {
                return (b = this.getRoot(this.getSetting(b))) ? b.treeTools : null
            }, initCache: function (b) {
                for (var a = 0, c = y.length; a < c; a++)y[a].apply(this,
                    arguments)
            }, initNode: function (b, a, c, d, f, g) {
                for (var e = 0, h = z.length; e < h; e++)z[e].apply(this, arguments)
            }, initRoot: function (b) {
                for (var a = 0, c = A.length; a < c; a++)A[a].apply(this, arguments)
            }, isSelectedNode: function (b, a) {
                for (var c = h.getRoot(b), d = 0, f = c.curSelectedList.length; d < f; d++)if (a === c.curSelectedList[d])return !0;
                return !1
            }, removeNodeCache: function (b, a) {
                var c = b.data.key.children;
                if (a[c])for (var d = 0, f = a[c].length; d < f; d++)arguments.callee(b, a[c][d]);
                h.getCache(b).nodes[h.getNodeCacheId(a.tId)] = null
            }, removeSelectedNode: function (b,
                                             a) {
                for (var c = h.getRoot(b), d = 0, f = c.curSelectedList.length; d < f; d++)if (a === c.curSelectedList[d] || !h.getNodeCache(b, c.curSelectedList[d].tId)) c.curSelectedList.splice(d, 1), d--, f--
            }, setCache: function (b, a) {
                v[b.treeId] = a
            }, setRoot: function (b, a) {
                u[b.treeId] = a
            }, setZTreeTools: function (b, a) {
                for (var c = 0, d = F.length; c < d; c++)F[c].apply(this, arguments)
            }, transformToArrayFormat: function (b, a) {
                if (!a)return [];
                var c = b.data.key.children, d = [];
                if (j.isArray(a))for (var f = 0, g = a.length; f < g; f++)d.push(a[f]), a[f][c] && (d = d.concat(h.transformToArrayFormat(b,
                    a[f][c]))); else d.push(a), a[c] && (d = d.concat(h.transformToArrayFormat(b, a[c])));
                return d
            }, transformTozTreeFormat: function (b, a) {
                var c, d, f = b.data.simpleData.idKey, g = b.data.simpleData.pIdKey, e = b.data.key.children;
                if (!f || f == "" || !a)return [];
                if (j.isArray(a)) {
                    var h = [], i = [];
                    for (c = 0, d = a.length; c < d; c++)i[a[c][f]] = a[c];
                    for (c = 0, d = a.length; c < d; c++)i[a[c][g]] && a[c][f] != a[c][g] ? (i[a[c][g]][e] || (i[a[c][g]][e] = []), i[a[c][g]][e].push(a[c])) : h.push(a[c]);
                    return h
                } else return [a]
            }
        }, m = {
            bindEvent: function (b) {
                for (var a = 0,
                         c = w.length; a < c; a++)w[a].apply(this, arguments)
            }, unbindEvent: function (b) {
                for (var a = 0, c = x.length; a < c; a++)x[a].apply(this, arguments)
            }, bindTree: function (b) {
                var a = {treeId: b.treeId}, c = b.treeObj;
                b.view.txtSelectedEnable || c.bind("selectstart", function (a) {
                    a = a.originalEvent.srcElement.nodeName.toLowerCase();
                    return a === "input" || a === "textarea"
                }).css({"-moz-user-select": "-moz-none"});
                c.bind("click", a, m.proxy);
                c.bind("dblclick", a, m.proxy);
                c.bind("mouseover", a, m.proxy);
                c.bind("mouseout", a, m.proxy);
                c.bind("mousedown",
                    a, m.proxy);
                c.bind("mouseup", a, m.proxy);
                c.bind("contextmenu", a, m.proxy)
            }, unbindTree: function (b) {
                b.treeObj.unbind("click", m.proxy).unbind("dblclick", m.proxy).unbind("mouseover", m.proxy).unbind("mouseout", m.proxy).unbind("mousedown", m.proxy).unbind("mouseup", m.proxy).unbind("contextmenu", m.proxy)
            }, doProxy: function (b) {
                for (var a = [], c = 0, d = s.length; c < d; c++) {
                    var f = s[c].apply(this, arguments);
                    a.push(f);
                    if (f.stop)break
                }
                return a
            }, proxy: function (b) {
                var a = h.getSetting(b.data.treeId);
                if (!j.uCanDo(a, b))return !0;
                for (var a = m.doProxy(b), c = !0, d = 0, f = a.length; d < f; d++) {
                    var g = a[d];
                    g.nodeEventCallback && (c = g.nodeEventCallback.apply(g, [b, g.node]) && c);
                    g.treeEventCallback && (c = g.treeEventCallback.apply(g, [b, g.node]) && c)
                }
                return c
            }
        };
    G = function (b, a) {
        var c = h.getSetting(b.data.treeId);
        if (a.open) {
            if (j.apply(c.callback.beforeCollapse, [c.treeId, a], !0) == !1)return !0
        } else if (j.apply(c.callback.beforeExpand, [c.treeId, a], !0) == !1)return !0;
        h.getRoot(c).expandTriggerFlag = !0;
        i.switchNode(c, a);
        return !0
    };
    H = function (b, a) {
        var c = h.getSetting(b.data.treeId),
            d = c.view.autoCancelSelected && b.ctrlKey && h.isSelectedNode(c, a) ? 0 : c.view.autoCancelSelected && b.ctrlKey && c.view.selectedMulti ? 2 : 1;
        if (j.apply(c.callback.beforeClick, [c.treeId, a, d], !0) == !1)return !0;
        d === 0 ? i.cancelPreSelectedNode(c, a) : i.selectNode(c, a, d === 2);
        c.treeObj.trigger(e.event.CLICK, [b, c.treeId, a, d]);
        return !0
    };
    I = function (b, a) {
        var c = h.getSetting(b.data.treeId);
        j.apply(c.callback.beforeMouseDown, [c.treeId, a], !0) && j.apply(c.callback.onMouseDown, [b, c.treeId, a]);
        return !0
    };
    J = function (b, a) {
        var c = h.getSetting(b.data.treeId);
        j.apply(c.callback.beforeMouseUp, [c.treeId, a], !0) && j.apply(c.callback.onMouseUp, [b, c.treeId, a]);
        return !0
    };
    K = function (b, a) {
        var c = h.getSetting(b.data.treeId);
        j.apply(c.callback.beforeDblClick, [c.treeId, a], !0) && j.apply(c.callback.onDblClick, [b, c.treeId, a]);
        return !0
    };
    L = function (b, a) {
        var c = h.getSetting(b.data.treeId);
        j.apply(c.callback.beforeRightClick, [c.treeId, a], !0) && j.apply(c.callback.onRightClick, [b, c.treeId, a]);
        return typeof c.callback.onRightClick != "function"
    };
    var j = {
        apply: function (b, a, c) {
            return typeof b ==
            "function" ? b.apply(N, a ? a : []) : c
        }, canAsync: function (b, a) {
            var c = b.data.key.children;
            return b.async.enable && a && a.isParent && !(a.zAsync || a[c] && a[c].length > 0)
        }, clone: function (b) {
            if (b === null)return null;
            var a = j.isArray(b) ? [] : {}, c;
            for (c in b)a[c] = b[c] instanceof Date ? new Date(b[c].getTime()) : typeof b[c] === "object" ? arguments.callee(b[c]) : b[c];
            return a
        }, eqs: function (b, a) {
            return b.toLowerCase() === a.toLowerCase()
        }, isArray: function (b) {
            return Object.prototype.toString.apply(b) === "[object Array]"
        }, $: function (b, a,
                        c) {
            a && typeof a != "string" && (c = a, a = "");
            return typeof b == "string" ? p(b, c ? c.treeObj.get(0).ownerDocument : null) : p("#" + b.tId + a, c ? c.treeObj : null)
        }, getMDom: function (b, a, c) {
            if (!a)return null;
            for (; a && a.id !== b.treeId;) {
                for (var d = 0, f = c.length; a.tagName && d < f; d++)if (j.eqs(a.tagName, c[d].tagName) && a.getAttribute(c[d].attrName) !== null)return a;
                a = a.parentNode
            }
            return null
        }, getNodeMainDom: function (b) {
            return p(b).parent("li").get(0) || p(b).parentsUntil("li").parent().get(0)
        }, isChildOrSelf: function (b, a) {
            return p(b).closest("#" +
                    a).length > 0
        }, uCanDo: function () {
            return !0
        }
    }, i = {
        addNodes: function (b, a, c, d) {
            if (!b.data.keep.leaf || !a || a.isParent)if (j.isArray(c) || (c = [c]), b.data.simpleData.enable && (c = h.transformTozTreeFormat(b, c)), a) {
                var f = k(a, e.id.SWITCH, b), g = k(a, e.id.ICON, b), l = k(a, e.id.UL, b);
                if (!a.open) i.replaceSwitchClass(a, f, e.folder.CLOSE), i.replaceIcoClass(a, g, e.folder.CLOSE), a.open = !1, l.css({display: "none"});
                h.addNodesData(b, a, c);
                i.createNodes(b, a.level + 1, c, a);
                d || i.expandCollapseParentNode(b, a, !0)
            } else h.addNodesData(b, h.getRoot(b),
                c), i.createNodes(b, 0, c, null)
        }, appendNodes: function (b, a, c, d, f, g) {
            if (!c)return [];
            for (var e = [], j = b.data.key.children, k = 0, m = c.length; k < m; k++) {
                var o = c[k];
                if (f) {
                    var t = (d ? d : h.getRoot(b))[j].length == c.length && k == 0;
                    h.initNode(b, a, o, d, t, k == c.length - 1, g);
                    h.addNodeCache(b, o)
                }
                t = [];
                o[j] && o[j].length > 0 && (t = i.appendNodes(b, a + 1, o[j], o, f, g && o.open));
                g && (i.makeDOMNodeMainBefore(e, b, o), i.makeDOMNodeLine(e, b, o), h.getBeforeA(b, o, e), i.makeDOMNodeNameBefore(e, b, o), h.getInnerBeforeA(b, o, e), i.makeDOMNodeIcon(e, b, o), h.getInnerAfterA(b,
                    o, e), i.makeDOMNodeNameAfter(e, b, o), h.getAfterA(b, o, e), o.isParent && o.open && i.makeUlHtml(b, o, e, t.join("")), i.makeDOMNodeMainAfter(e, b, o), h.addCreatedNode(b, o))
            }
            return e
        }, appendParentULDom: function (b, a) {
            var c = [], d = k(a, b);
            !d.get(0) && a.parentTId && (i.appendParentULDom(b, a.getParentNode()), d = k(a, b));
            var f = k(a, e.id.UL, b);
            f.get(0) && f.remove();
            f = i.appendNodes(b, a.level + 1, a[b.data.key.children], a, !1, !0);
            i.makeUlHtml(b, a, c, f.join(""));
            d.append(c.join(""))
        }, asyncNode: function (b, a, c, d) {
            var f, g;
            if (a && !a.isParent)return j.apply(d),
                !1; else if (a && a.isAjaxing)return !1; else if (j.apply(b.callback.beforeAsync, [b.treeId, a], !0) == !1)return j.apply(d), !1;
            if (a) a.isAjaxing = !0, k(a, e.id.ICON, b).attr({
                style: "",
                "class": e.className.BUTTON + " " + e.className.ICO_LOADING
            });
            var l = {};
            for (f = 0, g = b.async.autoParam.length; a && f < g; f++) {
                var q = b.async.autoParam[f].split("="), n = q;
                q.length > 1 && (n = q[1], q = q[0]);
                l[n] = a[q]
            }
            if (j.isArray(b.async.otherParam))for (f = 0, g = b.async.otherParam.length; f < g; f += 2)l[b.async.otherParam[f]] = b.async.otherParam[f + 1]; else for (var m in b.async.otherParam)l[m] =
                b.async.otherParam[m];
            var o = h.getRoot(b)._ver;
            p.ajax({
                contentType: b.async.contentType,
                type: b.async.type,
                url: j.apply(b.async.url, [b.treeId, a], b.async.url),
                data: l,
                dataType: b.async.dataType,
                success: function (f) {
                    if (o == h.getRoot(b)._ver) {
                        var g = [];
                        try {
                            g = !f || f.length == 0 ? [] : typeof f == "string" ? eval("(" + f + ")") : f
                        } catch (l) {
                            g = f
                        }
                        if (a) a.isAjaxing = null, a.zAsync = !0;
                        i.setNodeLineIcos(b, a);
                        g && g !== "" ? (g = j.apply(b.async.dataFilter, [b.treeId, a, g], g), i.addNodes(b, a, g ? j.clone(g) : [], !!c)) : i.addNodes(b, a, [], !!c);
                        b.treeObj.trigger(e.event.ASYNC_SUCCESS,
                            [b.treeId, a, f]);
                        j.apply(d)
                    }
                },
                error: function (c, d, f) {
                    if (o == h.getRoot(b)._ver) {
                        if (a) a.isAjaxing = null;
                        i.setNodeLineIcos(b, a);
                        b.treeObj.trigger(e.event.ASYNC_ERROR, [b.treeId, a, c, d, f])
                    }
                }
            });
            return !0
        }, cancelPreSelectedNode: function (b, a) {
            for (var c = h.getRoot(b).curSelectedList, d = c.length - 1; d >= 0; d--)if (!a || a === c[d])if (k(c[d], e.id.A, b).removeClass(e.node.CURSELECTED), a) {
                h.removeSelectedNode(b, a);
                break
            }
            if (!a) h.getRoot(b).curSelectedList = []
        }, createNodeCallback: function (b) {
            if (b.callback.onNodeCreated || b.view.addDiyDom)for (var a =
                h.getRoot(b); a.createdNodes.length > 0;) {
                var c = a.createdNodes.shift();
                j.apply(b.view.addDiyDom, [b.treeId, c]);
                b.callback.onNodeCreated && b.treeObj.trigger(e.event.NODECREATED, [b.treeId, c])
            }
        }, createNodes: function (b, a, c, d) {
            if (c && c.length != 0) {
                var f = h.getRoot(b), g = b.data.key.children, g = !d || d.open || !!k(d[g][0], b).get(0);
                f.createdNodes = [];
                a = i.appendNodes(b, a, c, d, !0, g);
                d ? (d = k(d, e.id.UL, b), d.get(0) && d.append(a.join(""))) : b.treeObj.append(a.join(""));
                i.createNodeCallback(b)
            }
        }, destroy: function (b) {
            b && (h.initCache(b),
                h.initRoot(b), m.unbindTree(b), m.unbindEvent(b), b.treeObj.empty())
        }, expandCollapseNode: function (b, a, c, d, f) {
            var g = h.getRoot(b), l = b.data.key.children;
            if (a) {
                if (g.expandTriggerFlag) {
                    var q = f, f = function () {
                        q && q();
                        a.open ? b.treeObj.trigger(e.event.EXPAND, [b.treeId, a]) : b.treeObj.trigger(e.event.COLLAPSE, [b.treeId, a])
                    };
                    g.expandTriggerFlag = !1
                }
                if (!a.open && a.isParent && (!k(a, e.id.UL, b).get(0) || a[l] && a[l].length > 0 && !k(a[l][0], b).get(0))) i.appendParentULDom(b, a), i.createNodeCallback(b);
                if (a.open == c) j.apply(f, []); else {
                    var c =
                        k(a, e.id.UL, b), g = k(a, e.id.SWITCH, b), n = k(a, e.id.ICON, b);
                    a.isParent ? (a.open = !a.open, a.iconOpen && a.iconClose && n.attr("style", i.makeNodeIcoStyle(b, a)), a.open ? (i.replaceSwitchClass(a, g, e.folder.OPEN), i.replaceIcoClass(a, n, e.folder.OPEN), d == !1 || b.view.expandSpeed == "" ? (c.show(), j.apply(f, [])) : a[l] && a[l].length > 0 ? c.slideDown(b.view.expandSpeed, f) : (c.show(), j.apply(f, []))) : (i.replaceSwitchClass(a, g, e.folder.CLOSE), i.replaceIcoClass(a, n, e.folder.CLOSE), d == !1 || b.view.expandSpeed == "" || !(a[l] && a[l].length > 0) ?
                        (c.hide(), j.apply(f, [])) : c.slideUp(b.view.expandSpeed, f))) : j.apply(f, [])
                }
            } else j.apply(f, [])
        }, expandCollapseParentNode: function (b, a, c, d, f) {
            a && (a.parentTId ? (i.expandCollapseNode(b, a, c, d), a.parentTId && i.expandCollapseParentNode(b, a.getParentNode(), c, d, f)) : i.expandCollapseNode(b, a, c, d, f))
        }, expandCollapseSonNode: function (b, a, c, d, f) {
            var g = h.getRoot(b), e = b.data.key.children, g = a ? a[e] : g[e], e = a ? !1 : d, j = h.getRoot(b).expandTriggerFlag;
            h.getRoot(b).expandTriggerFlag = !1;
            if (g)for (var k = 0, m = g.length; k < m; k++)g[k] &&
            i.expandCollapseSonNode(b, g[k], c, e);
            h.getRoot(b).expandTriggerFlag = j;
            i.expandCollapseNode(b, a, c, d, f)
        }, makeDOMNodeIcon: function (b, a, c) {
            var d = h.getNodeName(a, c), d = a.view.nameIsHTML ? d : d.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;");
            b.push("<span id='", c.tId, e.id.ICON, "' title='' treeNode", e.id.ICON, " class='", i.makeNodeIcoClass(a, c), "' style='", i.makeNodeIcoStyle(a, c), "'></span><span id='", c.tId, e.id.SPAN, "'>", d, "</span>")
        }, makeDOMNodeLine: function (b, a, c) {
            b.push("<span id='", c.tId,
                e.id.SWITCH, "' title='' class='", i.makeNodeLineClass(a, c), "' treeNode", e.id.SWITCH, "></span>")
        }, makeDOMNodeMainAfter: function (b) {
            b.push("</li>")
        }, makeDOMNodeMainBefore: function (b, a, c) {
            b.push("<li id='", c.tId, "' class='", e.className.LEVEL, c.level, "' tabindex='0' hidefocus='true' treenode>")
        }, makeDOMNodeNameAfter: function (b) {
            b.push("</a>")
        }, makeDOMNodeNameBefore: function (b, a, c) {
            var d = h.getNodeTitle(a, c), f = i.makeNodeUrl(a, c), g = i.makeNodeFontCss(a, c), l = [], k;
            for (k in g)l.push(k, ":", g[k], ";");
            b.push("<a id='",
                c.tId, e.id.A, "' class='", e.className.LEVEL, c.level, "' treeNode", e.id.A, ' onclick="', c.click || "", '" ', f != null && f.length > 0 ? "href='" + f + "'" : "", " target='", i.makeNodeTarget(c), "' style='", l.join(""), "'");
            j.apply(a.view.showTitle, [a.treeId, c], a.view.showTitle) && d && b.push("title='", d.replace(/'/g, "&#39;").replace(/</g, "&lt;").replace(/>/g, "&gt;"), "'");
            b.push(">")
        }, makeNodeFontCss: function (b, a) {
            var c = j.apply(b.view.fontCss, [b.treeId, a], b.view.fontCss);
            return c && typeof c != "function" ? c : {}
        }, makeNodeIcoClass: function (b,
                                       a) {
            var c = ["ico"];
            a.isAjaxing || (c[0] = (a.iconSkin ? a.iconSkin + "_" : "") + c[0], a.isParent ? c.push(a.open ? e.folder.OPEN : e.folder.CLOSE) : c.push(e.folder.DOCU));
            return e.className.BUTTON + " " + c.join("_")
        }, makeNodeIcoStyle: function (b, a) {
            var c = [];
            if (!a.isAjaxing) {
                var d = a.isParent && a.iconOpen && a.iconClose ? a.open ? a.iconOpen : a.iconClose : a.icon;
                d && c.push("background:url(", d, ") 0 0 no-repeat;");
                (b.view.showIcon == !1 || !j.apply(b.view.showIcon, [b.treeId, a], !0)) && c.push("width:0px;height:0px;")
            }
            return c.join("")
        }, makeNodeLineClass: function (b,
                                        a) {
            var c = [];
            b.view.showLine ? a.level == 0 && a.isFirstNode && a.isLastNode ? c.push(e.line.ROOT) : a.level == 0 && a.isFirstNode ? c.push(e.line.ROOTS) : a.isLastNode ? c.push(e.line.BOTTOM) : c.push(e.line.CENTER) : c.push(e.line.NOLINE);
            a.isParent ? c.push(a.open ? e.folder.OPEN : e.folder.CLOSE) : c.push(e.folder.DOCU);
            return i.makeNodeLineClassEx(a) + c.join("_")
        }, makeNodeLineClassEx: function (b) {
            return e.className.BUTTON + " " + e.className.LEVEL + b.level + " " + e.className.SWITCH + " "
        }, makeNodeTarget: function (b) {
            return b.target || "_blank"
        },
        makeNodeUrl: function (b, a) {
            var c = b.data.key.url;
            return a[c] ? a[c] : null
        }, makeUlHtml: function (b, a, c, d) {
            c.push("<ul id='", a.tId, e.id.UL, "' class='", e.className.LEVEL, a.level, " ", i.makeUlLineClass(b, a), "' style='display:", a.open ? "block" : "none", "'>");
            c.push(d);
            c.push("</ul>")
        }, makeUlLineClass: function (b, a) {
            return b.view.showLine && !a.isLastNode ? e.line.LINE : ""
        }, removeChildNodes: function (b, a) {
            if (a) {
                var c = b.data.key.children, d = a[c];
                if (d) {
                    for (var f = 0, g = d.length; f < g; f++)h.removeNodeCache(b, d[f]);
                    h.removeSelectedNode(b);
                    delete a[c];
                    b.data.keep.parent ? k(a, e.id.UL, b).empty() : (a.isParent = !1, a.open = !1, c = k(a, e.id.SWITCH, b), d = k(a, e.id.ICON, b), i.replaceSwitchClass(a, c, e.folder.DOCU), i.replaceIcoClass(a, d, e.folder.DOCU), k(a, e.id.UL, b).remove())
                }
            }
        }, setFirstNode: function (b, a) {
            var c = b.data.key.children;
            if (a[c].length > 0) a[c][0].isFirstNode = !0
        }, setLastNode: function (b, a) {
            var c = b.data.key.children, d = a[c].length;
            if (d > 0) a[c][d - 1].isLastNode = !0
        }, removeNode: function (b, a) {
            var c = h.getRoot(b), d = b.data.key.children, f = a.parentTId ? a.getParentNode() :
                c;
            a.isFirstNode = !1;
            a.isLastNode = !1;
            a.getPreNode = function () {
                return null
            };
            a.getNextNode = function () {
                return null
            };
            if (h.getNodeCache(b, a.tId)) {
                k(a, b).remove();
                h.removeNodeCache(b, a);
                h.removeSelectedNode(b, a);
                for (var g = 0, l = f[d].length; g < l; g++)if (f[d][g].tId == a.tId) {
                    f[d].splice(g, 1);
                    break
                }
                i.setFirstNode(b, f);
                i.setLastNode(b, f);
                var j, g = f[d].length;
                if (!b.data.keep.parent && g == 0) f.isParent = !1, f.open = !1, g = k(f, e.id.UL, b), l = k(f, e.id.SWITCH, b), j = k(f, e.id.ICON, b), i.replaceSwitchClass(f, l, e.folder.DOCU), i.replaceIcoClass(f,
                    j, e.folder.DOCU), g.css("display", "none"); else if (b.view.showLine && g > 0) {
                    var n = f[d][g - 1], g = k(n, e.id.UL, b), l = k(n, e.id.SWITCH, b);
                    j = k(n, e.id.ICON, b);
                    f == c ? f[d].length == 1 ? i.replaceSwitchClass(n, l, e.line.ROOT) : (c = k(f[d][0], e.id.SWITCH, b), i.replaceSwitchClass(f[d][0], c, e.line.ROOTS), i.replaceSwitchClass(n, l, e.line.BOTTOM)) : i.replaceSwitchClass(n, l, e.line.BOTTOM);
                    g.removeClass(e.line.LINE)
                }
            }
        }, replaceIcoClass: function (b, a, c) {
            if (a && !b.isAjaxing && (b = a.attr("class"), b != void 0)) {
                b = b.split("_");
                switch (c) {
                    case e.folder.OPEN:
                    case e.folder.CLOSE:
                    case e.folder.DOCU:
                        b[b.length -
                        1] = c
                }
                a.attr("class", b.join("_"))
            }
        }, replaceSwitchClass: function (b, a, c) {
            if (a) {
                var d = a.attr("class");
                if (d != void 0) {
                    d = d.split("_");
                    switch (c) {
                        case e.line.ROOT:
                        case e.line.ROOTS:
                        case e.line.CENTER:
                        case e.line.BOTTOM:
                        case e.line.NOLINE:
                            d[0] = i.makeNodeLineClassEx(b) + c;
                            break;
                        case e.folder.OPEN:
                        case e.folder.CLOSE:
                        case e.folder.DOCU:
                            d[1] = c
                    }
                    a.attr("class", d.join("_"));
                    c !== e.folder.DOCU ? a.removeAttr("disabled") : a.attr("disabled", "disabled")
                }
            }
        }, selectNode: function (b, a, c) {
            c || i.cancelPreSelectedNode(b);
            k(a, e.id.A,
                b).addClass(e.node.CURSELECTED);
            h.addSelectedNode(b, a)
        }, setNodeFontCss: function (b, a) {
            var c = k(a, e.id.A, b), d = i.makeNodeFontCss(b, a);
            d && c.css(d)
        }, setNodeLineIcos: function (b, a) {
            if (a) {
                var c = k(a, e.id.SWITCH, b), d = k(a, e.id.UL, b), f = k(a, e.id.ICON, b), g = i.makeUlLineClass(b, a);
                g.length == 0 ? d.removeClass(e.line.LINE) : d.addClass(g);
                c.attr("class", i.makeNodeLineClass(b, a));
                a.isParent ? c.removeAttr("disabled") : c.attr("disabled", "disabled");
                f.removeAttr("style");
                f.attr("style", i.makeNodeIcoStyle(b, a));
                f.attr("class",
                    i.makeNodeIcoClass(b, a))
            }
        }, setNodeName: function (b, a) {
            var c = h.getNodeTitle(b, a), d = k(a, e.id.SPAN, b);
            d.empty();
            b.view.nameIsHTML ? d.html(h.getNodeName(b, a)) : d.text(h.getNodeName(b, a));
            j.apply(b.view.showTitle, [b.treeId, a], b.view.showTitle) && k(a, e.id.A, b).attr("title", !c ? "" : c)
        }, setNodeTarget: function (b, a) {
            k(a, e.id.A, b).attr("target", i.makeNodeTarget(a))
        }, setNodeUrl: function (b, a) {
            var c = k(a, e.id.A, b), d = i.makeNodeUrl(b, a);
            d == null || d.length == 0 ? c.removeAttr("href") : c.attr("href", d)
        }, switchNode: function (b, a) {
            a.open || !j.canAsync(b, a) ? i.expandCollapseNode(b, a, !a.open) : b.async.enable ? i.asyncNode(b, a) || i.expandCollapseNode(b, a, !a.open) : a && i.expandCollapseNode(b, a, !a.open)
        }
    };
    p.fn.zTree = {
        consts: {
            className: {BUTTON: "button", LEVEL: "level", ICO_LOADING: "ico_loading", SWITCH: "switch"},
            event: {
                NODECREATED: "ztree_nodeCreated",
                CLICK: "ztree_click",
                EXPAND: "ztree_expand",
                COLLAPSE: "ztree_collapse",
                ASYNC_SUCCESS: "ztree_async_success",
                ASYNC_ERROR: "ztree_async_error"
            },
            id: {A: "_a", ICON: "_ico", SPAN: "_span", SWITCH: "_switch", UL: "_ul"},
            line: {
                ROOT: "root",
                ROOTS: "roots", CENTER: "center", BOTTOM: "bottom", NOLINE: "noline", LINE: "line"
            },
            folder: {OPEN: "open", CLOSE: "close", DOCU: "docu"},
            node: {CURSELECTED: "curSelectedNode"}
        }, _z: {tools: j, view: i, event: m, data: h}, getZTreeObj: function (b) {
            return (b = h.getZTreeTools(b)) ? b : null
        }, destroy: function (b) {
            if (b && b.length > 0) i.destroy(h.getSetting(b)); else for (var a in r)i.destroy(r[a])
        }, init: function (b, a, c) {
            var d = j.clone(M);
            p.extend(!0, d, a);
            d.treeId = b.attr("id");
            d.treeObj = b;
            d.treeObj.empty();
            r[d.treeId] = d;
            if (typeof document.body.style.maxHeight ===
                "undefined") d.view.expandSpeed = "";
            h.initRoot(d);
            b = h.getRoot(d);
            a = d.data.key.children;
            c = c ? j.clone(j.isArray(c) ? c : [c]) : [];
            b[a] = d.data.simpleData.enable ? h.transformTozTreeFormat(d, c) : c;
            h.initCache(d);
            m.unbindTree(d);
            m.bindTree(d);
            m.unbindEvent(d);
            m.bindEvent(d);
            c = {
                setting: d, addNodes: function (a, b, c) {
                    function e() {
                        i.addNodes(d, a, h, c == !0)
                    }

                    if (!b)return null;
                    a || (a = null);
                    if (a && !a.isParent && d.data.keep.leaf)return null;
                    var h = j.clone(j.isArray(b) ? b : [b]);
                    j.canAsync(d, a) ? i.asyncNode(d, a, c, e) : e();
                    return h
                }, cancelSelectedNode: function (a) {
                    i.cancelPreSelectedNode(d,
                        a)
                }, destroy: function () {
                    i.destroy(d)
                }, expandAll: function (a) {
                    a = !!a;
                    i.expandCollapseSonNode(d, null, a, !0);
                    return a
                }, expandNode: function (a, b, c, e, n) {
                    if (!a || !a.isParent)return null;
                    b !== !0 && b !== !1 && (b = !a.open);
                    if ((n = !!n) && b && j.apply(d.callback.beforeExpand, [d.treeId, a], !0) == !1)return null; else if (n && !b && j.apply(d.callback.beforeCollapse, [d.treeId, a], !0) == !1)return null;
                    b && a.parentTId && i.expandCollapseParentNode(d, a.getParentNode(), b, !1);
                    if (b === a.open && !c)return null;
                    h.getRoot(d).expandTriggerFlag = n;
                    if (!j.canAsync(d,
                            a) && c) i.expandCollapseSonNode(d, a, b, !0, function () {
                        if (e !== !1)try {
                            k(a, d).focus().blur()
                        } catch (b) {
                        }
                    }); else if (a.open = !b, i.switchNode(this.setting, a), e !== !1)try {
                        k(a, d).focus().blur()
                    } catch (m) {
                    }
                    return b
                }, getNodes: function () {
                    return h.getNodes(d)
                }, getNodeByParam: function (a, b, c) {
                    return !a ? null : h.getNodeByParam(d, c ? c[d.data.key.children] : h.getNodes(d), a, b)
                }, getNodeByTId: function (a) {
                    return h.getNodeCache(d, a)
                }, getNodesByParam: function (a, b, c) {
                    return !a ? null : h.getNodesByParam(d, c ? c[d.data.key.children] : h.getNodes(d),
                        a, b)
                }, getNodesByParamFuzzy: function (a, b, c) {
                    return !a ? null : h.getNodesByParamFuzzy(d, c ? c[d.data.key.children] : h.getNodes(d), a, b)
                }, getNodesByFilter: function (a, b, c, e) {
                    b = !!b;
                    return !a || typeof a != "function" ? b ? null : [] : h.getNodesByFilter(d, c ? c[d.data.key.children] : h.getNodes(d), a, b, e)
                }, getNodeIndex: function (a) {
                    if (!a)return null;
                    for (var b = d.data.key.children, c = a.parentTId ? a.getParentNode() : h.getRoot(d), e = 0, i = c[b].length; e < i; e++)if (c[b][e] == a)return e;
                    return -1
                }, getSelectedNodes: function () {
                    for (var a = [], b = h.getRoot(d).curSelectedList,
                             c = 0, e = b.length; c < e; c++)a.push(b[c]);
                    return a
                }, isSelectedNode: function (a) {
                    return h.isSelectedNode(d, a)
                }, reAsyncChildNodes: function (a, b, c) {
                    if (this.setting.async.enable) {
                        var j = !a;
                        j && (a = h.getRoot(d));
                        if (b == "refresh") {
                            for (var b = this.setting.data.key.children, m = 0, p = a[b] ? a[b].length : 0; m < p; m++)h.removeNodeCache(d, a[b][m]);
                            h.removeSelectedNode(d);
                            a[b] = [];
                            j ? this.setting.treeObj.empty() : k(a, e.id.UL, d).empty()
                        }
                        i.asyncNode(this.setting, j ? null : a, !!c)
                    }
                }, refresh: function () {
                    this.setting.treeObj.empty();
                    var a = h.getRoot(d),
                        b = a[d.data.key.children];
                    h.initRoot(d);
                    a[d.data.key.children] = b;
                    h.initCache(d);
                    i.createNodes(d, 0, a[d.data.key.children])
                }, removeChildNodes: function (a) {
                    if (!a)return null;
                    var b = a[d.data.key.children];
                    i.removeChildNodes(d, a);
                    return b ? b : null
                }, removeNode: function (a, b) {
                    a && (b = !!b, b && j.apply(d.callback.beforeRemove, [d.treeId, a], !0) == !1 || (i.removeNode(d, a), b && this.setting.treeObj.trigger(e.event.REMOVE, [d.treeId, a])))
                }, selectNode: function (a, b) {
                    if (a && j.uCanDo(d)) {
                        b = d.view.selectedMulti && b;
                        if (a.parentTId) i.expandCollapseParentNode(d,
                            a.getParentNode(), !0, !1, function () {
                                try {
                                    k(a, d).focus().blur()
                                } catch (b) {
                                }
                            }); else try {
                            k(a, d).focus().blur()
                        } catch (c) {
                        }
                        i.selectNode(d, a, b)
                    }
                }, transformTozTreeNodes: function (a) {
                    return h.transformTozTreeFormat(d, a)
                }, transformToArray: function (a) {
                    return h.transformToArrayFormat(d, a)
                }, updateNode: function (a) {
                    a && k(a, d).get(0) && j.uCanDo(d) && (i.setNodeName(d, a), i.setNodeTarget(d, a), i.setNodeUrl(d, a), i.setNodeLineIcos(d, a), i.setNodeFontCss(d, a))
                }
            };
            b.treeTools = c;
            h.setZTreeTools(d, c);
            b[a] && b[a].length > 0 ? i.createNodes(d,
                0, b[a]) : d.async.enable && d.async.url && d.async.url !== "" && i.asyncNode(d);
            return c
        }
    };
    var N = p.fn.zTree, k = j.$, e = N.consts
})(jQuery);

/*
 * JQuery zTree excheck v3.5.15
 * http://zTree.me/
 *
 * Copyright (c) 2010 Hunter.z
 *
 * Licensed same as jquery - MIT License
 * http://www.opensource.org/licenses/mit-license.php
 *
 * email: hunter.z@263.net
 * Date: 2013-10-15
 */
(function (m) {
    var p, q, r, o = {
        event: {CHECK: "ztree_check"},
        id: {CHECK: "_check"},
        checkbox: {
            STYLE: "checkbox",
            DEFAULT: "chk",
            DISABLED: "disable",
            FALSE: "false",
            TRUE: "true",
            FULL: "full",
            PART: "part",
            FOCUS: "focus"
        },
        radio: {STYLE: "radio", TYPE_ALL: "all", TYPE_LEVEL: "level"}
    }, v = {
        check: {
            enable: !1,
            autoCheckTrigger: !1,
            chkStyle: o.checkbox.STYLE,
            nocheckInherit: !1,
            chkDisabledInherit: !1,
            radioType: o.radio.TYPE_LEVEL,
            chkboxType: {Y: "ps", N: "ps"}
        }, data: {key: {checked: "checked"}}, callback: {beforeCheck: null, onCheck: null}
    };
    p = function (b,
                  a) {
        if (a.chkDisabled === !0)return !1;
        var c = f.getSetting(b.data.treeId), d = c.data.key.checked;
        if (k.apply(c.callback.beforeCheck, [c.treeId, a], !0) == !1)return !0;
        a[d] = !a[d];
        e.checkNodeRelation(c, a);
        d = n(a, j.id.CHECK, c);
        e.setChkClass(c, d, a);
        e.repairParentChkClassWithSelf(c, a);
        c.treeObj.trigger(j.event.CHECK, [b, c.treeId, a]);
        return !0
    };
    q = function (b, a) {
        if (a.chkDisabled === !0)return !1;
        var c = f.getSetting(b.data.treeId), d = n(a, j.id.CHECK, c);
        a.check_Focus = !0;
        e.setChkClass(c, d, a);
        return !0
    };
    r = function (b, a) {
        if (a.chkDisabled === !0)return !1;
        var c = f.getSetting(b.data.treeId), d = n(a, j.id.CHECK, c);
        a.check_Focus = !1;
        e.setChkClass(c, d, a);
        return !0
    };
    m.extend(!0, m.fn.zTree.consts, o);
    m.extend(!0, m.fn.zTree._z, {
        tools: {}, view: {
            checkNodeRelation: function (b, a) {
                var c, d, h, i = b.data.key.children, l = b.data.key.checked;
                c = j.radio;
                if (b.check.chkStyle == c.STYLE) {
                    var g = f.getRadioCheckedList(b);
                    if (a[l])if (b.check.radioType == c.TYPE_ALL) {
                        for (d = g.length - 1; d >= 0; d--)c = g[d], c[l] = !1, g.splice(d, 1), e.setChkClass(b, n(c, j.id.CHECK, b), c), c.parentTId != a.parentTId &&
                        e.repairParentChkClassWithSelf(b, c);
                        g.push(a)
                    } else {
                        g = a.parentTId ? a.getParentNode() : f.getRoot(b);
                        for (d = 0, h = g[i].length; d < h; d++)c = g[i][d], c[l] && c != a && (c[l] = !1, e.setChkClass(b, n(c, j.id.CHECK, b), c))
                    } else if (b.check.radioType == c.TYPE_ALL)for (d = 0, h = g.length; d < h; d++)if (a == g[d]) {
                        g.splice(d, 1);
                        break
                    }
                } else a[l] && (!a[i] || a[i].length == 0 || b.check.chkboxType.Y.indexOf("s") > -1) && e.setSonNodeCheckBox(b, a, !0), !a[l] && (!a[i] || a[i].length == 0 || b.check.chkboxType.N.indexOf("s") > -1) && e.setSonNodeCheckBox(b, a, !1), a[l] &&
                b.check.chkboxType.Y.indexOf("p") > -1 && e.setParentNodeCheckBox(b, a, !0), !a[l] && b.check.chkboxType.N.indexOf("p") > -1 && e.setParentNodeCheckBox(b, a, !1)
            }, makeChkClass: function (b, a) {
                var c = b.data.key.checked, d = j.checkbox, h = j.radio, i = "", i = a.chkDisabled === !0 ? d.DISABLED : a.halfCheck ? d.PART : b.check.chkStyle == h.STYLE ? a.check_Child_State < 1 ? d.FULL : d.PART : a[c] ? a.check_Child_State === 2 || a.check_Child_State === -1 ? d.FULL : d.PART : a.check_Child_State < 1 ? d.FULL : d.PART, c = b.check.chkStyle + "_" + (a[c] ? d.TRUE : d.FALSE) + "_" + i, c = a.check_Focus &&
                a.chkDisabled !== !0 ? c + "_" + d.FOCUS : c;
                return j.className.BUTTON + " " + d.DEFAULT + " " + c
            }, repairAllChk: function (b, a) {
                if (b.check.enable && b.check.chkStyle === j.checkbox.STYLE)for (var c = b.data.key.checked, d = b.data.key.children, h = f.getRoot(b), i = 0, l = h[d].length; i < l; i++) {
                    var g = h[d][i];
                    g.nocheck !== !0 && g.chkDisabled !== !0 && (g[c] = a);
                    e.setSonNodeCheckBox(b, g, a)
                }
            }, repairChkClass: function (b, a) {
                if (a && (f.makeChkFlag(b, a), a.nocheck !== !0)) {
                    var c = n(a, j.id.CHECK, b);
                    e.setChkClass(b, c, a)
                }
            }, repairParentChkClass: function (b, a) {
                if (a &&
                    a.parentTId) {
                    var c = a.getParentNode();
                    e.repairChkClass(b, c);
                    e.repairParentChkClass(b, c)
                }
            }, repairParentChkClassWithSelf: function (b, a) {
                if (a) {
                    var c = b.data.key.children;
                    a[c] && a[c].length > 0 ? e.repairParentChkClass(b, a[c][0]) : e.repairParentChkClass(b, a)
                }
            }, repairSonChkDisabled: function (b, a, c, d) {
                if (a) {
                    var h = b.data.key.children;
                    if (a.chkDisabled != c) a.chkDisabled = c;
                    e.repairChkClass(b, a);
                    if (a[h] && d)for (var i = 0, l = a[h].length; i < l; i++)e.repairSonChkDisabled(b, a[h][i], c, d)
                }
            }, repairParentChkDisabled: function (b, a, c,
                                                  d) {
                if (a) {
                    if (a.chkDisabled != c && d) a.chkDisabled = c;
                    e.repairChkClass(b, a);
                    e.repairParentChkDisabled(b, a.getParentNode(), c, d)
                }
            }, setChkClass: function (b, a, c) {
                a && (c.nocheck === !0 ? a.hide() : a.show(), a.removeClass(), a.addClass(e.makeChkClass(b, c)))
            }, setParentNodeCheckBox: function (b, a, c, d) {
                var h = b.data.key.children, i = b.data.key.checked, l = n(a, j.id.CHECK, b);
                d || (d = a);
                f.makeChkFlag(b, a);
                a.nocheck !== !0 && a.chkDisabled !== !0 && (a[i] = c, e.setChkClass(b, l, a), b.check.autoCheckTrigger && a != d && b.treeObj.trigger(j.event.CHECK,
                    [null, b.treeId, a]));
                if (a.parentTId) {
                    l = !0;
                    if (!c)for (var h = a.getParentNode()[h], g = 0, k = h.length; g < k; g++)if (h[g].nocheck !== !0 && h[g].chkDisabled !== !0 && h[g][i] || (h[g].nocheck === !0 || h[g].chkDisabled === !0) && h[g].check_Child_State > 0) {
                        l = !1;
                        break
                    }
                    l && e.setParentNodeCheckBox(b, a.getParentNode(), c, d)
                }
            }, setSonNodeCheckBox: function (b, a, c, d) {
                if (a) {
                    var h = b.data.key.children, i = b.data.key.checked, l = n(a, j.id.CHECK, b);
                    d || (d = a);
                    var g = !1;
                    if (a[h])for (var k = 0, m = a[h].length; k < m && a.chkDisabled !== !0; k++) {
                        var o = a[h][k];
                        e.setSonNodeCheckBox(b,
                            o, c, d);
                        o.chkDisabled === !0 && (g = !0)
                    }
                    if (a != f.getRoot(b) && a.chkDisabled !== !0) {
                        g && a.nocheck !== !0 && f.makeChkFlag(b, a);
                        if (a.nocheck !== !0 && a.chkDisabled !== !0) {
                            if (a[i] = c, !g) a.check_Child_State = a[h] && a[h].length > 0 ? c ? 2 : 0 : -1
                        } else a.check_Child_State = -1;
                        e.setChkClass(b, l, a);
                        b.check.autoCheckTrigger && a != d && a.nocheck !== !0 && a.chkDisabled !== !0 && b.treeObj.trigger(j.event.CHECK, [null, b.treeId, a])
                    }
                }
            }
        }, event: {}, data: {
            getRadioCheckedList: function (b) {
                for (var a = f.getRoot(b).radioCheckedList, c = 0, d = a.length; c < d; c++)f.getNodeCache(b,
                    a[c].tId) || (a.splice(c, 1), c--, d--);
                return a
            }, getCheckStatus: function (b, a) {
                if (!b.check.enable || a.nocheck || a.chkDisabled)return null;
                var c = b.data.key.checked;
                return {
                    checked: a[c],
                    half: a.halfCheck ? a.halfCheck : b.check.chkStyle == j.radio.STYLE ? a.check_Child_State === 2 : a[c] ? a.check_Child_State > -1 && a.check_Child_State < 2 : a.check_Child_State > 0
                }
            }, getTreeCheckedNodes: function (b, a, c, d) {
                if (!a)return [];
                for (var h = b.data.key.children, i = b.data.key.checked, e = c && b.check.chkStyle == j.radio.STYLE && b.check.radioType == j.radio.TYPE_ALL,
                         d = !d ? [] : d, g = 0, k = a.length; g < k; g++) {
                    if (a[g].nocheck !== !0 && a[g].chkDisabled !== !0 && a[g][i] == c && (d.push(a[g]), e))break;
                    f.getTreeCheckedNodes(b, a[g][h], c, d);
                    if (e && d.length > 0)break
                }
                return d
            }, getTreeChangeCheckedNodes: function (b, a, c) {
                if (!a)return [];
                for (var d = b.data.key.children, h = b.data.key.checked, c = !c ? [] : c, i = 0, e = a.length; i < e; i++)a[i].nocheck !== !0 && a[i].chkDisabled !== !0 && a[i][h] != a[i].checkedOld && c.push(a[i]), f.getTreeChangeCheckedNodes(b, a[i][d], c);
                return c
            }, makeChkFlag: function (b, a) {
                if (a) {
                    var c = b.data.key.children,
                        d = b.data.key.checked, h = -1;
                    if (a[c])for (var i = 0, e = a[c].length; i < e; i++) {
                        var g = a[c][i], f = -1;
                        if (b.check.chkStyle == j.radio.STYLE)if (f = g.nocheck === !0 || g.chkDisabled === !0 ? g.check_Child_State : g.halfCheck === !0 ? 2 : g[d] ? 2 : g.check_Child_State > 0 ? 2 : 0, f == 2) {
                            h = 2;
                            break
                        } else f == 0 && (h = 0); else if (b.check.chkStyle == j.checkbox.STYLE)if (f = g.nocheck === !0 || g.chkDisabled === !0 ? g.check_Child_State : g.halfCheck === !0 ? 1 : g[d] ? g.check_Child_State === -1 || g.check_Child_State === 2 ? 2 : 1 : g.check_Child_State > 0 ? 1 : 0, f === 1) {
                            h = 1;
                            break
                        } else if (f ===
                            2 && h > -1 && i > 0 && f !== h) {
                            h = 1;
                            break
                        } else if (h === 2 && f > -1 && f < 2) {
                            h = 1;
                            break
                        } else f > -1 && (h = f)
                    }
                    a.check_Child_State = h
                }
            }
        }
    });
    var m = m.fn.zTree, k = m._z.tools, j = m.consts, e = m._z.view, f = m._z.data, n = k.$;
    f.exSetting(v);
    f.addInitBind(function (b) {
        b.treeObj.bind(j.event.CHECK, function (a, c, d, h) {
            k.apply(b.callback.onCheck, [c ? c : a, d, h])
        })
    });
    f.addInitUnBind(function (b) {
        b.treeObj.unbind(j.event.CHECK)
    });
    f.addInitCache(function () {
    });
    f.addInitNode(function (b, a, c, d) {
        if (c) {
            a = b.data.key.checked;
            typeof c[a] == "string" && (c[a] = k.eqs(c[a],
                "true"));
            c[a] = !!c[a];
            c.checkedOld = c[a];
            if (typeof c.nocheck == "string") c.nocheck = k.eqs(c.nocheck, "true");
            c.nocheck = !!c.nocheck || b.check.nocheckInherit && d && !!d.nocheck;
            if (typeof c.chkDisabled == "string") c.chkDisabled = k.eqs(c.chkDisabled, "true");
            c.chkDisabled = !!c.chkDisabled || b.check.chkDisabledInherit && d && !!d.chkDisabled;
            if (typeof c.halfCheck == "string") c.halfCheck = k.eqs(c.halfCheck, "true");
            c.halfCheck = !!c.halfCheck;
            c.check_Child_State = -1;
            c.check_Focus = !1;
            c.getCheckStatus = function () {
                return f.getCheckStatus(b,
                    c)
            };
            b.check.chkStyle == j.radio.STYLE && b.check.radioType == j.radio.TYPE_ALL && c[a] && f.getRoot(b).radioCheckedList.push(c)
        }
    });
    f.addInitProxy(function (b) {
        var a = b.target, c = f.getSetting(b.data.treeId), d = "", h = null, e = "", l = null;
        if (k.eqs(b.type, "mouseover")) {
            if (c.check.enable && k.eqs(a.tagName, "span") && a.getAttribute("treeNode" + j.id.CHECK) !== null) d = k.getNodeMainDom(a).id, e = "mouseoverCheck"
        } else if (k.eqs(b.type, "mouseout")) {
            if (c.check.enable && k.eqs(a.tagName, "span") && a.getAttribute("treeNode" + j.id.CHECK) !== null) d =
                k.getNodeMainDom(a).id, e = "mouseoutCheck"
        } else if (k.eqs(b.type, "click") && c.check.enable && k.eqs(a.tagName, "span") && a.getAttribute("treeNode" + j.id.CHECK) !== null) d = k.getNodeMainDom(a).id, e = "checkNode";
        if (d.length > 0)switch (h = f.getNodeCache(c, d), e) {
            case "checkNode":
                l = p;
                break;
            case "mouseoverCheck":
                l = q;
                break;
            case "mouseoutCheck":
                l = r
        }
        return {
            stop: e === "checkNode",
            node: h,
            nodeEventType: e,
            nodeEventCallback: l,
            treeEventType: "",
            treeEventCallback: null
        }
    }, !0);
    f.addInitRoot(function (b) {
        f.getRoot(b).radioCheckedList = []
    });
    f.addBeforeA(function (b, a, c) {
        b.check.enable && (f.makeChkFlag(b, a), c.push("<span ID='", a.tId, j.id.CHECK, "' class='", e.makeChkClass(b, a), "' treeNode", j.id.CHECK, a.nocheck === !0 ? " style='display:none;'" : "", "></span>"))
    });
    f.addZTreeTools(function (b, a) {
        a.checkNode = function (a, c, i, f) {
            var g = b.data.key.checked;
            if (a.chkDisabled !== !0 && (c !== !0 && c !== !1 && (c = !a[g]), f = !!f, (a[g] !== c || i) && !(f && k.apply(this.setting.callback.beforeCheck, [b.treeId, a], !0) == !1) && k.uCanDo(this.setting) && b.check.enable && a.nocheck !== !0)) a[g] =
                c, c = n(a, j.id.CHECK, b), (i || b.check.chkStyle === j.radio.STYLE) && e.checkNodeRelation(b, a), e.setChkClass(b, c, a), e.repairParentChkClassWithSelf(b, a), f && b.treeObj.trigger(j.event.CHECK, [null, b.treeId, a])
        };
        a.checkAllNodes = function (a) {
            e.repairAllChk(b, !!a)
        };
        a.getCheckedNodes = function (a) {
            var c = b.data.key.children;
            return f.getTreeCheckedNodes(b, f.getRoot(b)[c], a !== !1)
        };
        a.getChangeCheckedNodes = function () {
            var a = b.data.key.children;
            return f.getTreeChangeCheckedNodes(b, f.getRoot(b)[a])
        };
        a.setChkDisabled = function (a,
                                     c, f, j) {
            c = !!c;
            f = !!f;
            e.repairSonChkDisabled(b, a, c, !!j);
            e.repairParentChkDisabled(b, a.getParentNode(), c, f)
        };
        var c = a.updateNode;
        a.updateNode = function (d, f) {
            c && c.apply(a, arguments);
            if (d && b.check.enable && n(d, b).get(0) && k.uCanDo(b)) {
                var i = n(d, j.id.CHECK, b);
                (f == !0 || b.check.chkStyle === j.radio.STYLE) && e.checkNodeRelation(b, d);
                e.setChkClass(b, i, d);
                e.repairParentChkClassWithSelf(b, d)
            }
        }
    });
    var s = e.createNodes;
    e.createNodes = function (b, a, c, d) {
        s && s.apply(e, arguments);
        c && e.repairParentChkClassWithSelf(b, d)
    };
    var t = e.removeNode;
    e.removeNode = function (b, a) {
        var c = a.getParentNode();
        t && t.apply(e, arguments);
        a && c && (e.repairChkClass(b, c), e.repairParentChkClass(b, c))
    };
    var u = e.appendNodes;
    e.appendNodes = function (b, a, c, d, h, i) {
        var j = "";
        u && (j = u.apply(e, arguments));
        d && f.makeChkFlag(b, d);
        return j
    }
})(jQuery);

/*
 * JQuery zTree exedit v3.5.15
 * http://zTree.me/
 *
 * Copyright (c) 2010 Hunter.z
 *
 * Licensed same as jquery - MIT License
 * http://www.opensource.org/licenses/mit-license.php
 *
 * email: hunter.z@263.net
 * Date: 2013-10-15
 */
(function (w) {
    var I = {
        event: {DRAG: "ztree_drag", DROP: "ztree_drop", REMOVE: "ztree_remove", RENAME: "ztree_rename"},
        id: {EDIT: "_edit", INPUT: "_input", REMOVE: "_remove"},
        move: {TYPE_INNER: "inner", TYPE_PREV: "prev", TYPE_NEXT: "next"},
        node: {
            CURSELECTED_EDIT: "curSelectedNode_Edit",
            TMPTARGET_TREE: "tmpTargetzTree",
            TMPTARGET_NODE: "tmpTargetNode"
        }
    }, x = {
        onHoverOverNode: function (b, a) {
            var c = n.getSetting(b.data.treeId), d = n.getRoot(c);
            if (d.curHoverNode != a) x.onHoverOutNode(b);
            d.curHoverNode = a;
            e.addHoverDom(c, a)
        }, onHoverOutNode: function (b) {
            var b =
                n.getSetting(b.data.treeId), a = n.getRoot(b);
            if (a.curHoverNode && !n.isSelectedNode(b, a.curHoverNode)) e.removeTreeDom(b, a.curHoverNode), a.curHoverNode = null
        }, onMousedownNode: function (b, a) {
            function c(b) {
                if (B.dragFlag == 0 && Math.abs(N - b.clientX) < f.edit.drag.minMoveSize && Math.abs(O - b.clientY) < f.edit.drag.minMoveSize)return !0;
                var a, c, o, k, i;
                i = f.data.key.children;
                M.css("cursor", "pointer");
                if (B.dragFlag == 0) {
                    if (g.apply(f.callback.beforeDrag, [f.treeId, m], !0) == !1)return l(b), !0;
                    for (a = 0, c = m.length; a < c; a++) {
                        if (a == 0) B.dragNodeShowBefore =
                            [];
                        o = m[a];
                        o.isParent && o.open ? (e.expandCollapseNode(f, o, !o.open), B.dragNodeShowBefore[o.tId] = !0) : B.dragNodeShowBefore[o.tId] = !1
                    }
                    B.dragFlag = 1;
                    t.showHoverDom = !1;
                    g.showIfameMask(f, !0);
                    o = !0;
                    k = -1;
                    if (m.length > 1) {
                        var j = m[0].parentTId ? m[0].getParentNode()[i] : n.getNodes(f);
                        i = [];
                        for (a = 0, c = j.length; a < c; a++)if (B.dragNodeShowBefore[j[a].tId] !== void 0 && (o && k > -1 && k + 1 !== a && (o = !1), i.push(j[a]), k = a), m.length === i.length) {
                            m = i;
                            break
                        }
                    }
                    o && (H = m[0].getPreNode(), R = m[m.length - 1].getNextNode());
                    C = p("<ul class='zTreeDragUL'></ul>",
                        f);
                    for (a = 0, c = m.length; a < c; a++)if (o = m[a], o.editNameFlag = !1, e.selectNode(f, o, a > 0), e.removeTreeDom(f, o), k = p("<li id='" + o.tId + "_tmp'></li>", f), k.append(p(o, d.id.A, f).clone()), k.css("padding", "0"), k.children("#" + o.tId + d.id.A).removeClass(d.node.CURSELECTED), C.append(k), a == f.edit.drag.maxShowNodeNum - 1) {
                        k = p("<li id='" + o.tId + "_moretmp'><a>  ...  </a></li>", f);
                        C.append(k);
                        break
                    }
                    C.attr("id", m[0].tId + d.id.UL + "_tmp");
                    C.addClass(f.treeObj.attr("class"));
                    C.appendTo(M);
                    A = p("<span class='tmpzTreeMove_arrow'></span>",
                        f);
                    A.attr("id", "zTreeMove_arrow_tmp");
                    A.appendTo(M);
                    f.treeObj.trigger(d.event.DRAG, [b, f.treeId, m])
                }
                if (B.dragFlag == 1) {
                    s && A.attr("id") == b.target.id && u && b.clientX + F.scrollLeft() + 2 > w("#" + u + d.id.A, s).offset().left ? (o = w("#" + u + d.id.A, s), b.target = o.length > 0 ? o.get(0) : b.target) : s && (s.removeClass(d.node.TMPTARGET_TREE), u && w("#" + u + d.id.A, s).removeClass(d.node.TMPTARGET_NODE + "_" + d.move.TYPE_PREV).removeClass(d.node.TMPTARGET_NODE + "_" + I.move.TYPE_NEXT).removeClass(d.node.TMPTARGET_NODE + "_" + I.move.TYPE_INNER));
                    u = s = null;
                    J = !1;
                    h = f;
                    o = n.getSettings();
                    for (var D in o)if (o[D].treeId && o[D].edit.enable && o[D].treeId != f.treeId && (b.target.id == o[D].treeId || w(b.target).parents("#" + o[D].treeId).length > 0)) J = !0, h = o[D];
                    D = F.scrollTop();
                    k = F.scrollLeft();
                    i = h.treeObj.offset();
                    a = h.treeObj.get(0).scrollHeight;
                    o = h.treeObj.get(0).scrollWidth;
                    c = b.clientY + D - i.top;
                    var q = h.treeObj.height() + i.top - b.clientY - D, r = b.clientX + k - i.left, x = h.treeObj.width() + i.left - b.clientX - k;
                    i = c < f.edit.drag.borderMax && c > f.edit.drag.borderMin;
                    var j = q < f.edit.drag.borderMax &&
                        q > f.edit.drag.borderMin, K = r < f.edit.drag.borderMax && r > f.edit.drag.borderMin, G = x < f.edit.drag.borderMax && x > f.edit.drag.borderMin, q = c > f.edit.drag.borderMin && q > f.edit.drag.borderMin && r > f.edit.drag.borderMin && x > f.edit.drag.borderMin, r = i && h.treeObj.scrollTop() <= 0, x = j && h.treeObj.scrollTop() + h.treeObj.height() + 10 >= a, P = K && h.treeObj.scrollLeft() <= 0, Q = G && h.treeObj.scrollLeft() + h.treeObj.width() + 10 >= o;
                    if (b.target && g.isChildOrSelf(b.target, h.treeId)) {
                        for (var E = b.target; E && E.tagName && !g.eqs(E.tagName, "li") && E.id !=
                        h.treeId;)E = E.parentNode;
                        var S = !0;
                        for (a = 0, c = m.length; a < c; a++)if (o = m[a], E.id === o.tId) {
                            S = !1;
                            break
                        } else if (p(o, f).find("#" + E.id).length > 0) {
                            S = !1;
                            break
                        }
                        if (S && b.target && g.isChildOrSelf(b.target, E.id + d.id.A)) s = w(E), u = E.id
                    }
                    o = m[0];
                    if (q && g.isChildOrSelf(b.target, h.treeId)) {
                        if (!s && (b.target.id == h.treeId || r || x || P || Q) && (J || !J && o.parentTId)) s = h.treeObj;
                        i ? h.treeObj.scrollTop(h.treeObj.scrollTop() - 10) : j && h.treeObj.scrollTop(h.treeObj.scrollTop() + 10);
                        K ? h.treeObj.scrollLeft(h.treeObj.scrollLeft() - 10) : G && h.treeObj.scrollLeft(h.treeObj.scrollLeft() +
                            10);
                        s && s != h.treeObj && s.offset().left < h.treeObj.offset().left && h.treeObj.scrollLeft(h.treeObj.scrollLeft() + s.offset().left - h.treeObj.offset().left)
                    }
                    C.css({top: b.clientY + D + 3 + "px", left: b.clientX + k + 3 + "px"});
                    i = a = 0;
                    if (s && s.attr("id") != h.treeId) {
                        var y = u == null ? null : n.getNodeCache(h, u);
                        c = b.ctrlKey && f.edit.drag.isMove && f.edit.drag.isCopy || !f.edit.drag.isMove && f.edit.drag.isCopy;
                        a = !!(H && u === H.tId);
                        i = !!(R && u === R.tId);
                        k = o.parentTId && o.parentTId == u;
                        o = (c || !i) && g.apply(h.edit.drag.prev, [h.treeId, m, y], !!h.edit.drag.prev);
                        a = (c || !a) && g.apply(h.edit.drag.next, [h.treeId, m, y], !!h.edit.drag.next);
                        G = (c || !k) && !(h.data.keep.leaf && !y.isParent) && g.apply(h.edit.drag.inner, [h.treeId, m, y], !!h.edit.drag.inner);
                        if (!o && !a && !G) {
                            if (s = null, u = "", v = d.move.TYPE_INNER, A.css({display: "none"}), window.zTreeMoveTimer) clearTimeout(window.zTreeMoveTimer), window.zTreeMoveTargetNodeTId = null
                        } else {
                            c = w("#" + u + d.id.A, s);
                            i = y.isLastNode ? null : w("#" + y.getNextNode().tId + d.id.A, s.next());
                            j = c.offset().top;
                            k = c.offset().left;
                            K = o ? G ? 0.25 : a ? 0.5 : 1 : -1;
                            G = a ? G ? 0.75 :
                                o ? 0.5 : 0 : -1;
                            b = (b.clientY + D - j) / c.height();
                            (K == 1 || b <= K && b >= -0.2) && o ? (a = 1 - A.width(), i = j - A.height() / 2, v = d.move.TYPE_PREV) : (G == 0 || b >= G && b <= 1.2) && a ? (a = 1 - A.width(), i = i == null || y.isParent && y.open ? j + c.height() - A.height() / 2 : i.offset().top - A.height() / 2, v = d.move.TYPE_NEXT) : (a = 5 - A.width(), i = j, v = d.move.TYPE_INNER);
                            A.css({display: "block", top: i + "px", left: k + a + "px"});
                            c.addClass(d.node.TMPTARGET_NODE + "_" + v);
                            if (T != u || U != v) L = (new Date).getTime();
                            if (y && y.isParent && v == d.move.TYPE_INNER && (b = !0, window.zTreeMoveTimer && window.zTreeMoveTargetNodeTId !==
                                y.tId ? (clearTimeout(window.zTreeMoveTimer), window.zTreeMoveTargetNodeTId = null) : window.zTreeMoveTimer && window.zTreeMoveTargetNodeTId === y.tId && (b = !1), b)) window.zTreeMoveTimer = setTimeout(function () {
                                v == d.move.TYPE_INNER && y && y.isParent && !y.open && (new Date).getTime() - L > h.edit.drag.autoOpenTime && g.apply(h.callback.beforeDragOpen, [h.treeId, y], !0) && (e.switchNode(h, y), h.edit.drag.autoExpandTrigger && h.treeObj.trigger(d.event.EXPAND, [h.treeId, y]))
                            }, h.edit.drag.autoOpenTime + 50), window.zTreeMoveTargetNodeTId = y.tId
                        }
                    } else if (v =
                            d.move.TYPE_INNER, s && g.apply(h.edit.drag.inner, [h.treeId, m, null], !!h.edit.drag.inner) ? s.addClass(d.node.TMPTARGET_TREE) : s = null, A.css({display: "none"}), window.zTreeMoveTimer) clearTimeout(window.zTreeMoveTimer), window.zTreeMoveTargetNodeTId = null;
                    T = u;
                    U = v
                }
                return !1
            }

            function l(b) {
                if (window.zTreeMoveTimer) clearTimeout(window.zTreeMoveTimer), window.zTreeMoveTargetNodeTId = null;
                U = T = null;
                F.unbind("mousemove", c);
                F.unbind("mouseup", l);
                F.unbind("selectstart", k);
                M.css("cursor", "auto");
                s && (s.removeClass(d.node.TMPTARGET_TREE),
                u && w("#" + u + d.id.A, s).removeClass(d.node.TMPTARGET_NODE + "_" + d.move.TYPE_PREV).removeClass(d.node.TMPTARGET_NODE + "_" + I.move.TYPE_NEXT).removeClass(d.node.TMPTARGET_NODE + "_" + I.move.TYPE_INNER));
                g.showIfameMask(f, !1);
                t.showHoverDom = !0;
                if (B.dragFlag != 0) {
                    B.dragFlag = 0;
                    var a, i, j;
                    for (a = 0, i = m.length; a < i; a++)j = m[a], j.isParent && B.dragNodeShowBefore[j.tId] && !j.open && (e.expandCollapseNode(f, j, !j.open), delete B.dragNodeShowBefore[j.tId]);
                    C && C.remove();
                    A && A.remove();
                    var q = b.ctrlKey && f.edit.drag.isMove && f.edit.drag.isCopy ||
                        !f.edit.drag.isMove && f.edit.drag.isCopy;
                    !q && s && u && m[0].parentTId && u == m[0].parentTId && v == d.move.TYPE_INNER && (s = null);
                    if (s) {
                        var r = u == null ? null : n.getNodeCache(h, u);
                        if (g.apply(f.callback.beforeDrop, [h.treeId, m, r, v, q], !0) == !1) e.selectNodes(x, m); else {
                            var z = q ? g.clone(m) : m;
                            a = function () {
                                if (J) {
                                    if (!q)for (var a = 0, c = m.length; a < c; a++)e.removeNode(f, m[a]);
                                    if (v == d.move.TYPE_INNER) e.addNodes(h, r, z); else if (e.addNodes(h, r.getParentNode(), z), v == d.move.TYPE_PREV)for (a = 0, c = z.length; a < c; a++)e.moveNode(h, r, z[a], v, !1); else for (a = -1, c = z.length - 1; a < c; c--)e.moveNode(h, r, z[c], v, !1)
                                } else if (q && v == d.move.TYPE_INNER) e.addNodes(h, r, z); else if (q && e.addNodes(h, r.getParentNode(), z), v != d.move.TYPE_NEXT)for (a = 0, c = z.length; a < c; a++)e.moveNode(h, r, z[a], v, !1); else for (a = -1, c = z.length - 1; a < c; c--)e.moveNode(h, r, z[c], v, !1);
                                e.selectNodes(h, z);
                                p(z[0], f).focus().blur();
                                f.treeObj.trigger(d.event.DROP, [b, h.treeId, z, r, v, q])
                            };
                            v == d.move.TYPE_INNER && g.canAsync(h, r) ? e.asyncNode(h, r, !1, a) : a()
                        }
                    } else e.selectNodes(x, m), f.treeObj.trigger(d.event.DROP, [b, f.treeId,
                        m, null, null, null])
                }
            }

            function k() {
                return !1
            }

            var i, j, f = n.getSetting(b.data.treeId), B = n.getRoot(f), t = n.getRoots();
            if (b.button == 2 || !f.edit.enable || !f.edit.drag.isCopy && !f.edit.drag.isMove)return !0;
            var q = b.target, r = n.getRoot(f).curSelectedList, m = [];
            if (n.isSelectedNode(f, a))for (i = 0, j = r.length; i < j; i++) {
                if (r[i].editNameFlag && g.eqs(q.tagName, "input") && q.getAttribute("treeNode" + d.id.INPUT) !== null)return !0;
                m.push(r[i]);
                if (m[0].parentTId !== r[i].parentTId) {
                    m = [a];
                    break
                }
            } else m = [a];
            e.editNodeBlur = !0;
            e.cancelCurEditNode(f);
            var F = w(f.treeObj.get(0).ownerDocument), M = w(f.treeObj.get(0).ownerDocument.body), C, A, s, J = !1, h = f, x = f, H, R, T = null, U = null, u = null, v = d.move.TYPE_INNER, N = b.clientX, O = b.clientY, L = (new Date).getTime();
            g.uCanDo(f) && F.bind("mousemove", c);
            F.bind("mouseup", l);
            F.bind("selectstart", k);
            b.preventDefault && b.preventDefault();
            return !0
        }
    };
    w.extend(!0, w.fn.zTree.consts, I);
    w.extend(!0, w.fn.zTree._z, {
        tools: {
            getAbs: function (b) {
                b = b.getBoundingClientRect();
                return [b.left + (document.body.scrollLeft + document.documentElement.scrollLeft),
                    b.top + (document.body.scrollTop + document.documentElement.scrollTop)]
            }, inputFocus: function (b) {
                b.get(0) && (b.focus(), g.setCursorPosition(b.get(0), b.val().length))
            }, inputSelect: function (b) {
                b.get(0) && (b.focus(), b.select())
            }, setCursorPosition: function (b, a) {
                if (b.setSelectionRange) b.focus(), b.setSelectionRange(a, a); else if (b.createTextRange) {
                    var c = b.createTextRange();
                    c.collapse(!0);
                    c.moveEnd("character", a);
                    c.moveStart("character", a);
                    c.select()
                }
            }, showIfameMask: function (b, a) {
                for (var c = n.getRoot(b); c.dragMaskList.length >
                0;)c.dragMaskList[0].remove(), c.dragMaskList.shift();
                if (a)for (var d = p("iframe", b), e = 0, i = d.length; e < i; e++) {
                    var j = d.get(e), f = g.getAbs(j), j = p("<div id='zTreeMask_" + e + "' class='zTreeMask' style='top:" + f[1] + "px; left:" + f[0] + "px; width:" + j.offsetWidth + "px; height:" + j.offsetHeight + "px;'></div>", b);
                    j.appendTo(p("body", b));
                    c.dragMaskList.push(j)
                }
            }
        }, view: {
            addEditBtn: function (b, a) {
                if (!(a.editNameFlag || p(a, d.id.EDIT, b).length > 0) && g.apply(b.edit.showRenameBtn, [b.treeId, a], b.edit.showRenameBtn)) {
                    var c = p(a, d.id.A,
                        b), l = "<span class='" + d.className.BUTTON + " edit' id='" + a.tId + d.id.EDIT + "' title='" + g.apply(b.edit.renameTitle, [b.treeId, a], b.edit.renameTitle) + "' treeNode" + d.id.EDIT + " style='display:none;'></span>";
                    c.append(l);
                    p(a, d.id.EDIT, b).bind("click", function () {
                        if (!g.uCanDo(b) || g.apply(b.callback.beforeEditName, [b.treeId, a], !0) == !1)return !1;
                        e.editNode(b, a);
                        return !1
                    }).show()
                }
            }, addRemoveBtn: function (b, a) {
                if (!(a.editNameFlag || p(a, d.id.REMOVE, b).length > 0) && g.apply(b.edit.showRemoveBtn, [b.treeId, a], b.edit.showRemoveBtn)) {
                    var c =
                        p(a, d.id.A, b), l = "<span class='" + d.className.BUTTON + " remove' id='" + a.tId + d.id.REMOVE + "' title='" + g.apply(b.edit.removeTitle, [b.treeId, a], b.edit.removeTitle) + "' treeNode" + d.id.REMOVE + " style='display:none;'></span>";
                    c.append(l);
                    p(a, d.id.REMOVE, b).bind("click", function () {
                        if (!g.uCanDo(b) || g.apply(b.callback.beforeRemove, [b.treeId, a], !0) == !1)return !1;
                        e.removeNode(b, a);
                        b.treeObj.trigger(d.event.REMOVE, [b.treeId, a]);
                        return !1
                    }).bind("mousedown", function () {
                        return !0
                    }).show()
                }
            }, addHoverDom: function (b, a) {
                if (n.getRoots().showHoverDom) a.isHover = !0, b.edit.enable && (e.addEditBtn(b, a), e.addRemoveBtn(b, a)), g.apply(b.view.addHoverDom, [b.treeId, a])
            }, cancelCurEditNode: function (b, a, c) {
                var l = n.getRoot(b), k = b.data.key.name, i = l.curEditNode;
                if (i) {
                    var j = l.curEditInput, a = a ? a : c ? i[k] : j.val();
                    if (g.apply(b.callback.beforeRename, [b.treeId, i, a, c], !0) === !1)return !1; else i[k] = a, b.treeObj.trigger(d.event.RENAME, [b.treeId, i, c]);
                    p(i, d.id.A, b).removeClass(d.node.CURSELECTED_EDIT);
                    j.unbind();
                    e.setNodeName(b, i);
                    i.editNameFlag = !1;
                    l.curEditNode = null;
                    l.curEditInput = null;
                    e.selectNode(b, i, !1)
                }
                return l.noSelection = !0
            }, editNode: function (b, a) {
                var c = n.getRoot(b);
                e.editNodeBlur = !1;
                if (n.isSelectedNode(b, a) && c.curEditNode == a && a.editNameFlag) setTimeout(function () {
                    g.inputFocus(c.curEditInput)
                }, 0); else {
                    var l = b.data.key.name;
                    a.editNameFlag = !0;
                    e.removeTreeDom(b, a);
                    e.cancelCurEditNode(b);
                    e.selectNode(b, a, !1);
                    p(a, d.id.SPAN, b).html("<input type=text class='rename' id='" + a.tId + d.id.INPUT + "' treeNode" + d.id.INPUT + " >");
                    var k = p(a, d.id.INPUT, b);
                    k.attr("value", a[l]);
                    b.edit.editNameSelectAll ?
                        g.inputSelect(k) : g.inputFocus(k);
                    k.bind("blur", function () {
                        e.editNodeBlur || e.cancelCurEditNode(b)
                    }).bind("keydown", function (a) {
                        a.keyCode == "13" ? (e.editNodeBlur = !0, e.cancelCurEditNode(b)) : a.keyCode == "27" && e.cancelCurEditNode(b, null, !0)
                    }).bind("click", function () {
                        return !1
                    }).bind("dblclick", function () {
                        return !1
                    });
                    p(a, d.id.A, b).addClass(d.node.CURSELECTED_EDIT);
                    c.curEditInput = k;
                    c.noSelection = !1;
                    c.curEditNode = a
                }
            }, moveNode: function (b, a, c, l, k, i) {
                var j = n.getRoot(b), f = b.data.key.children;
                if (a != c && (!b.data.keep.leaf || !a || a.isParent || l != d.move.TYPE_INNER)) {
                    var g = c.parentTId ? c.getParentNode() : j, t = a === null || a == j;
                    t && a === null && (a = j);
                    if (t) l = d.move.TYPE_INNER;
                    j = a.parentTId ? a.getParentNode() : j;
                    if (l != d.move.TYPE_PREV && l != d.move.TYPE_NEXT) l = d.move.TYPE_INNER;
                    if (l == d.move.TYPE_INNER)if (t) c.parentTId = null; else {
                        if (!a.isParent) a.isParent = !0, a.open = !!a.open, e.setNodeLineIcos(b, a);
                        c.parentTId = a.tId
                    }
                    var q;
                    t ? q = t = b.treeObj : (!i && l == d.move.TYPE_INNER ? e.expandCollapseNode(b, a, !0, !1) : i || e.expandCollapseNode(b, a.getParentNode(), !0, !1),
                        t = p(a, b), q = p(a, d.id.UL, b), t.get(0) && !q.get(0) && (q = [], e.makeUlHtml(b, a, q, ""), t.append(q.join(""))), q = p(a, d.id.UL, b));
                    var r = p(c, b);
                    r.get(0) ? t.get(0) || r.remove() : r = e.appendNodes(b, c.level, [c], null, !1, !0).join("");
                    q.get(0) && l == d.move.TYPE_INNER ? q.append(r) : t.get(0) && l == d.move.TYPE_PREV ? t.before(r) : t.get(0) && l == d.move.TYPE_NEXT && t.after(r);
                    var m = -1, w = 0, x = null, t = null, C = c.level;
                    if (c.isFirstNode) {
                        if (m = 0, g[f].length > 1) x = g[f][1], x.isFirstNode = !0
                    } else if (c.isLastNode) m = g[f].length - 1, x = g[f][m - 1], x.isLastNode = !0; else for (q = 0, r = g[f].length; q < r; q++)if (g[f][q].tId == c.tId) {
                        m = q;
                        break
                    }
                    m >= 0 && g[f].splice(m, 1);
                    if (l != d.move.TYPE_INNER)for (q = 0, r = j[f].length; q < r; q++)j[f][q].tId == a.tId && (w = q);
                    if (l == d.move.TYPE_INNER) {
                        a[f] || (a[f] = []);
                        if (a[f].length > 0) t = a[f][a[f].length - 1], t.isLastNode = !1;
                        a[f].splice(a[f].length, 0, c);
                        c.isLastNode = !0;
                        c.isFirstNode = a[f].length == 1
                    } else a.isFirstNode && l == d.move.TYPE_PREV ? (j[f].splice(w, 0, c), t = a, t.isFirstNode = !1, c.parentTId = a.parentTId, c.isFirstNode = !0, c.isLastNode = !1) : a.isLastNode && l == d.move.TYPE_NEXT ?
                        (j[f].splice(w + 1, 0, c), t = a, t.isLastNode = !1, c.parentTId = a.parentTId, c.isFirstNode = !1, c.isLastNode = !0) : (l == d.move.TYPE_PREV ? j[f].splice(w, 0, c) : j[f].splice(w + 1, 0, c), c.parentTId = a.parentTId, c.isFirstNode = !1, c.isLastNode = !1);
                    n.fixPIdKeyValue(b, c);
                    n.setSonNodeLevel(b, c.getParentNode(), c);
                    e.setNodeLineIcos(b, c);
                    e.repairNodeLevelClass(b, c, C);
                    !b.data.keep.parent && g[f].length < 1 ? (g.isParent = !1, g.open = !1, a = p(g, d.id.UL, b), l = p(g, d.id.SWITCH, b), f = p(g, d.id.ICON, b), e.replaceSwitchClass(g, l, d.folder.DOCU), e.replaceIcoClass(g,
                        f, d.folder.DOCU), a.css("display", "none")) : x && e.setNodeLineIcos(b, x);
                    t && e.setNodeLineIcos(b, t);
                    b.check && b.check.enable && e.repairChkClass && (e.repairChkClass(b, g), e.repairParentChkClassWithSelf(b, g), g != c.parent && e.repairParentChkClassWithSelf(b, c));
                    i || e.expandCollapseParentNode(b, c.getParentNode(), !0, k)
                }
            }, removeEditBtn: function (b, a) {
                p(a, d.id.EDIT, b).unbind().remove()
            }, removeRemoveBtn: function (b, a) {
                p(a, d.id.REMOVE, b).unbind().remove()
            }, removeTreeDom: function (b, a) {
                a.isHover = !1;
                e.removeEditBtn(b, a);
                e.removeRemoveBtn(b,
                    a);
                g.apply(b.view.removeHoverDom, [b.treeId, a])
            }, repairNodeLevelClass: function (b, a, c) {
                if (c !== a.level) {
                    var e = p(a, b), g = p(a, d.id.A, b), b = p(a, d.id.UL, b), c = d.className.LEVEL + c, a = d.className.LEVEL + a.level;
                    e.removeClass(c);
                    e.addClass(a);
                    g.removeClass(c);
                    g.addClass(a);
                    b.removeClass(c);
                    b.addClass(a)
                }
            }, selectNodes: function (b, a) {
                for (var c = 0, d = a.length; c < d; c++)e.selectNode(b, a[c], c > 0)
            }
        }, event: {}, data: {
            setSonNodeLevel: function (b, a, c) {
                if (c) {
                    var d = b.data.key.children;
                    c.level = a ? a.level + 1 : 0;
                    if (c[d])for (var a = 0, e = c[d].length; a <
                    e; a++)c[d][a] && n.setSonNodeLevel(b, c, c[d][a])
                }
            }
        }
    });
    var H = w.fn.zTree, g = H._z.tools, d = H.consts, e = H._z.view, n = H._z.data, p = g.$;
    n.exSetting({
        edit: {
            enable: !1,
            editNameSelectAll: !1,
            showRemoveBtn: !0,
            showRenameBtn: !0,
            removeTitle: "remove",
            renameTitle: "rename",
            drag: {
                autoExpandTrigger: !1,
                isCopy: !0,
                isMove: !0,
                prev: !0,
                next: !0,
                inner: !0,
                minMoveSize: 5,
                borderMax: 10,
                borderMin: -5,
                maxShowNodeNum: 5,
                autoOpenTime: 500
            }
        }, view: {addHoverDom: null, removeHoverDom: null}, callback: {
            beforeDrag: null, beforeDragOpen: null, beforeDrop: null,
            beforeEditName: null, beforeRename: null, onDrag: null, onDrop: null, onRename: null
        }
    });
    n.addInitBind(function (b) {
        var a = b.treeObj, c = d.event;
        a.bind(c.RENAME, function (a, c, d, e) {
            g.apply(b.callback.onRename, [a, c, d, e])
        });
        a.bind(c.REMOVE, function (a, c, d) {
            g.apply(b.callback.onRemove, [a, c, d])
        });
        a.bind(c.DRAG, function (a, c, d, e) {
            g.apply(b.callback.onDrag, [c, d, e])
        });
        a.bind(c.DROP, function (a, c, d, e, f, n, p) {
            g.apply(b.callback.onDrop, [c, d, e, f, n, p])
        })
    });
    n.addInitUnBind(function (b) {
        var b = b.treeObj, a = d.event;
        b.unbind(a.RENAME);
        b.unbind(a.REMOVE);
        b.unbind(a.DRAG);
        b.unbind(a.DROP)
    });
    n.addInitCache(function () {
    });
    n.addInitNode(function (b, a, c) {
        if (c) c.isHover = !1, c.editNameFlag = !1
    });
    n.addInitProxy(function (b) {
        var a = b.target, c = n.getSetting(b.data.treeId), e = b.relatedTarget, k = "", i = null, j = "", f = null, p = null;
        if (g.eqs(b.type, "mouseover")) {
            if (p = g.getMDom(c, a, [{
                    tagName: "a",
                    attrName: "treeNode" + d.id.A
                }])) k = g.getNodeMainDom(p).id, j = "hoverOverNode"
        } else if (g.eqs(b.type, "mouseout")) p = g.getMDom(c, e, [{tagName: "a", attrName: "treeNode" + d.id.A}]),
        p || (k = "remove", j = "hoverOutNode"); else if (g.eqs(b.type, "mousedown") && (p = g.getMDom(c, a, [{
                tagName: "a",
                attrName: "treeNode" + d.id.A
            }]))) k = g.getNodeMainDom(p).id, j = "mousedownNode";
        if (k.length > 0)switch (i = n.getNodeCache(c, k), j) {
            case "mousedownNode":
                f = x.onMousedownNode;
                break;
            case "hoverOverNode":
                f = x.onHoverOverNode;
                break;
            case "hoverOutNode":
                f = x.onHoverOutNode
        }
        return {stop: !1, node: i, nodeEventType: j, nodeEventCallback: f, treeEventType: "", treeEventCallback: null}
    });
    n.addInitRoot(function (b) {
        var b = n.getRoot(b), a = n.getRoots();
        b.curEditNode = null;
        b.curEditInput = null;
        b.curHoverNode = null;
        b.dragFlag = 0;
        b.dragNodeShowBefore = [];
        b.dragMaskList = [];
        a.showHoverDom = !0
    });
    n.addZTreeTools(function (b, a) {
        a.cancelEditName = function (a) {
            n.getRoot(b).curEditNode && e.cancelCurEditNode(b, a ? a : null, !0)
        };
        a.copyNode = function (a, l, k, i) {
            if (!l)return null;
            if (a && !a.isParent && b.data.keep.leaf && k === d.move.TYPE_INNER)return null;
            var j = g.clone(l);
            if (!a) a = null, k = d.move.TYPE_INNER;
            k == d.move.TYPE_INNER ? (l = function () {
                e.addNodes(b, a, [j], i)
            }, g.canAsync(b, a) ? e.asyncNode(b,
                a, i, l) : l()) : (e.addNodes(b, a.parentNode, [j], i), e.moveNode(b, a, j, k, !1, i));
            return j
        };
        a.editName = function (a) {
            a && a.tId && a === n.getNodeCache(b, a.tId) && (a.parentTId && e.expandCollapseParentNode(b, a.getParentNode(), !0), e.editNode(b, a))
        };
        a.moveNode = function (a, l, k, i) {
            function j() {
                e.moveNode(b, a, l, k, !1, i)
            }

            if (!l)return l;
            if (a && !a.isParent && b.data.keep.leaf && k === d.move.TYPE_INNER)return null; else if (a && (l.parentTId == a.tId && k == d.move.TYPE_INNER || p(l, b).find("#" + a.tId).length > 0))return null; else a || (a = null);
            g.canAsync(b,
                a) && k === d.move.TYPE_INNER ? e.asyncNode(b, a, i, j) : j();
            return l
        };
        a.setEditable = function (a) {
            b.edit.enable = a;
            return this.refresh()
        }
    });
    var N = e.cancelPreSelectedNode;
    e.cancelPreSelectedNode = function (b, a) {
        for (var c = n.getRoot(b).curSelectedList, d = 0, g = c.length; d < g; d++)if (!a || a === c[d])if (e.removeTreeDom(b, c[d]), a)break;
        N && N.apply(e, arguments)
    };
    var O = e.createNodes;
    e.createNodes = function (b, a, c, d) {
        O && O.apply(e, arguments);
        c && e.repairParentChkClassWithSelf && e.repairParentChkClassWithSelf(b, d)
    };
    var V = e.makeNodeUrl;
    e.makeNodeUrl = function (b, a) {
        return b.edit.enable ? null : V.apply(e, arguments)
    };
    var L = e.removeNode;
    e.removeNode = function (b, a) {
        var c = n.getRoot(b);
        if (c.curEditNode === a) c.curEditNode = null;
        L && L.apply(e, arguments)
    };
    var P = e.selectNode;
    e.selectNode = function (b, a, c) {
        var d = n.getRoot(b);
        if (n.isSelectedNode(b, a) && d.curEditNode == a && a.editNameFlag)return !1;
        P && P.apply(e, arguments);
        e.addHoverDom(b, a);
        return !0
    };
    var Q = g.uCanDo;
    g.uCanDo = function (b, a) {
        var c = n.getRoot(b);
        if (a && (g.eqs(a.type, "mouseover") || g.eqs(a.type, "mouseout") ||
            g.eqs(a.type, "mousedown") || g.eqs(a.type, "mouseup")))return !0;
        if (c.curEditNode) e.editNodeBlur = !1, c.curEditInput.focus();
        return !c.curEditNode && (Q ? Q.apply(e, arguments) : !0)
    }
})(jQuery);
$.ztree = $.fn.zTree;
$.fn.ztree = function () {
    return $.fn.zTree.init.apply(null, [this].concat([].slice.call(arguments)));
};

