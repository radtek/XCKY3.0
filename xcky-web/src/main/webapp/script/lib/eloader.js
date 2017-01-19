(function() {
    var _1 = {
        draggable: {js: "jquery.draggable.js"},
        droppable: {js: "jquery.droppable.js"},
        resizable: {js: "jquery.resizable.js"},
        linkbutton: {js: "jquery.linkbutton.js", css: "linkbutton.css"},
        progressbar: {js: "jquery.progressbar.js", css: "progressbar.css"},
        tooltip: {js: "jquery.tooltip.js", css: "tooltip.css"},
        pagination: {js: "jquery.pagination.js", css: "pagination.css", dependencies: ["linkbutton"] },
        datagrid: {js: "jquery.datagrid.js", css: "datagrid.css", dependencies: ["panel", "resizable", "linkbutton", "pagination"] },
        treegrid: {js: "jquery.treegrid.js", css: "tree.css", dependencies: ["datagrid"] },
        propertygrid: {js: "jquery.propertygrid.js", css: "propertygrid.css", dependencies: ["datagrid"] },
        datalist: {js: "jquery.datalist.js", css: "datalist.css", dependencies: ["datagrid"] },
        panel: {js: "jquery.panel.js", css: "panel.css"},
        window: {js: "jquery.window.js", css: "window.css", dependencies: ["resizable", "draggable", "panel"] },
        dialog: {js: "jquery.dialog.js", css: "dialog.css", dependencies: ["linkbutton", "window"] },
        messager: {js: "jquery.messager.js", css: "messager.css", dependencies: ["linkbutton", "window", "progressbar"] },
        layout: {js: "jquery.layout.js", css: "layout.css", dependencies: ["resizable", "panel"] },
        form: {js: "jquery.form.js"},
        menu: {js: "jquery.menu.js", css: "menu.css"},
        tabs: {js: "jquery.tabs.js", css: "tabs.css", dependencies: ["panel", "linkbutton"] },
        menubutton: {js: "jquery.menubutton.js", css: "menubutton.css", dependencies: ["linkbutton", "menu"] },
        splitbutton: {js: "jquery.splitbutton.js", css: "splitbutton.css", dependencies: ["menubutton"] },
        accordion: {js: "jquery.accordion.js", css: "accordion.css", dependencies: ["panel"] },
        calendar: {js: "jquery.calendar.js", css: "calendar.css"},
        textbox: {js: "jquery.textbox.js", css: "textbox.css", dependencies: ["validatebox", "linkbutton"] },
        filebox: {js: "jquery.filebox.js", css: "filebox.css", dependencies: ["textbox"] },
        combo: {js: "jquery.combo.js", css: "combo.css", dependencies: ["panel", "textbox"] },
        combobox: {js: "jquery.combobox.js", css: "combobox.css", dependencies: ["combo"] },
        combotree: {js: "jquery.combotree.js", dependencies: ["combo", "tree"] },
        combogrid: {js: "jquery.combogrid.js", dependencies: ["combo", "datagrid"] },
        validatebox: {js: "jquery.validatebox.js", css: "validatebox.css", dependencies: ["tooltip"] },
        numberbox: {js: "jquery.numberbox.js", dependencies: ["textbox"] },
        searchbox: {js: "jquery.searchbox.js", css: "searchbox.css", dependencies: ["menubutton", "textbox"] },
        spinner: {js: "jquery.spinner.js", css: "spinner.css", dependencies: ["textbox"] },
        numberspinner: {js: "jquery.numberspinner.js", dependencies: ["spinner", "numberbox"] },
        timespinner: {js: "jquery.timespinner.js", dependencies: ["spinner"] },
        tree: {js: "jquery.tree.js", css: "tree.css", dependencies: ["draggable", "droppable"] },
        datebox: {js: "jquery.datebox.js", css: "datebox.css", dependencies: ["calendar", "combo"] },
        datetimebox: {js: "jquery.datetimebox.js", dependencies: ["datebox", "timespinner"] },
        slider: {js: "jquery.slider.js", dependencies: ["draggable"] },
        tooltip: {js: "jquery.tooltip.js"},
        parser: {js: "jquery.parser.js"},
        mobile: {js: "jquery.mobile.js"}
    };
    var _2 = {
        "af": "eui-lang-af.js",
        "ar": "eui-lang-ar.js",
        "bg": "eui-lang-bg.js",
        "ca": "eui-lang-ca.js",
        "cs": "eui-lang-cs.js",
        "cz": "eui-lang-cz.js",
        "da": "eui-lang-da.js",
        "de": "eui-lang-de.js",
        "el": "eui-lang-el.js",
        "en": "eui-lang-en.js",
        "es": "eui-lang-es.js",
        "fr": "eui-lang-fr.js",
        "it": "eui-lang-it.js",
        "jp": "eui-lang-jp.js",
        "nl": "eui-lang-nl.js",
        "pl": "eui-lang-pl.js",
        "pt_BR": "eui-lang-pt_BR.js",
        "ru": "eui-lang-ru.js",
        "sv_SE": "eui-lang-sv_SE.js",
        "tr": "eui-lang-tr.js",
        "zh_CN": "eui-lang-zh_CN.js",
        "zh_TW": "eui-lang-zh_TW.js"
    };
    var _3 = {};

    function _4(src, cb) {
        var _7 = false;
        var tag = document.createElement("script");
        tag.type = "text/javascript";
        tag.language = "javascript";
        tag.src = src;
        tag.onload = tag.onreadystatechange = function() {
            if (!_7 && (!tag.readyState || tag.readyState == "loaded" || tag.readyState == "complete")) {
                _7 = true;
                tag.onload = tag.onreadystatechange = null;
                if (cb) {
                    cb.call(tag);
                }
            }
        };
        document.getElementsByTagName("head")[0].appendChild(_8);
    };

    function _9(_a, _b) {
        _4(_a, function () {
                document.getElementsByTagName("head")[0].removeChild(this);
                if (_b) {
                    _b();
                }
            });
    };

    function _c(_d, _e) {
        var _f = document.createElement("link");
        _f.rel = "stylesheet";
        _f.type = "text/css";
        _f.media = "screen";
        _f.href = _d;
        document.getElementsByTagName("head")[0].appendChild(_f);
        if (_e) {
            _e.call(_f);
        }
    };

    function _10(_11, _12) {
        _3[_11] = "loading";
        var _13 = _1[_11];
        var _14 = "loading";
        var _15 = (easyloader.css && _13["css"]) ? "loading": "loaded";
        if (easyloader.css && _13["css"]) {
            if (/^http/i.test(_13["css"])) {
                var url = _13["css"];
            } else {
                var url = easyloader.base + "themes/" + easyloader.theme + "/" + _13["css"];
            }
            _c(url,
                function() {
                    _15 = "loaded";
                    if (_14 == "loaded" && _15 == "loaded") {
                        _16();
                    }
                });
        }
        if (/^http/i.test(_13["js"])) {
            var url = _13["js"];
        } else {
            var url = easyloader.base + "plugins/" + _13["js"];
        }
        _4(url,
            function() {
                _14 = "loaded";
                if (_14 == "loaded" && _15 == "loaded") {
                    _16();
                }
            });
        function _16() {
            _3[_11] = "loaded";
            easyloader.onProgress(_11);
            if (_12) {
                _12();
            }
        };
    };
    function _17(_18, _19) {
        var mm = [];
        var _1a = false;
        if (typeof _18 == "string") {
            add(_18);
        } else {
            for (var i = 0; i < _18.length; i++) {
                add(_18[i]);
            }
        }
        function add(_1b) {
            if (!_1[_1b]) {
                return;
            }
            var d = _1[_1b]["dependencies"];
            if (d) {
                for (var i = 0; i < d.length; i++) {
                    add(d[i]);
                }
            }
            mm.push(_1b);
        };
        function _1c() {
            if (_19) {
                _19();
            }
            easyloader.onLoad(_18);
        };
        var _1d = 0;
        function _1e() {
            if (mm.length) {
                var m = mm[0];
                if (!_3[m]) {
                    _1a = true;
                    _10(m,
                        function() {
                            mm.shift();
                            _1e();
                        });
                } else {
                    if (_3[m] == "loaded") {
                        mm.shift();
                        _1e();
                    } else {
                        if (_1d < easyloader.timeout) {
                            _1d += 10;
                            setTimeout(arguments.callee, 10);
                        }
                    }
                }
            } else {
                if (easyloader.locale && _1a == true && _2[easyloader.locale]) {
                    var url = easyloader.base + "locale/" + _2[easyloader.locale];
                    _9(url,
                        function() {
                            _1c();
                        });
                } else {
                    _1c();
                }
            }
        };
        _1e();
    };
    easyloader = {
        modules: _1,
        locales: _2,
        base: ".",
        theme: "default",
        css: true,
        locale: null,
        timeout: 2000,
        load: function(_1f, _20) {
            if (/\.css$/i.test(_1f)) {
                if (/^http/i.test(_1f)) {
                    _c(_1f, _20);
                } else {
                    _c(easyloader.base + _1f, _20);
                }
            } else {
                if (/\.js$/i.test(_1f)) {
                    if (/^http/i.test(_1f)) {
                        _4(_1f, _20);
                    } else {
                        _4(easyloader.base + _1f, _20);
                    }
                } else {
                    _17(_1f, _20);
                }
            }
        },
        onProgress: function(_21) {},
        onLoad: function(_22) {}
    };
    var _23 = document.getElementsByTagName("script");
    for (var i = 0; i < _23.length; i++) {
        var src = _23[i].src;
        if (!src) {
            continue;
        }
        var m = src.match(/easyloader\.js(\W|$)/i);
        if (m) {
            easyloader.base = src.substring(0, m.index);
        }
    }
    window.using = easyloader.load;
    if (window.jQuery) {
        jQuery(function() {
            easyloader.load("parser", function () { jQuery.parser.parse(); });
        });
    }
})();

window.importing = function() {
    var ags = arguments;
    var cb = ags[ags.length - 1];
    var arr = [];
    for (var i = 0; i < arr.length - 2; i++) {
        arr.push(ags[i]);
        using(arr[i], function () {
                if (!arr[i + 1]) {
                    cb && cb();
                } else {
                    window.importing(arr.slice(i + 1), cb);
                }
            });
    }
}