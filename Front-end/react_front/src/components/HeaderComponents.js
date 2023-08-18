import React from "react";

const HeaderCompononet = () => {
    return(
        <div>
            <header>
                <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                    <div>
                        <a style={{margin:'1vh 2vw'  }} href="http://localhost:3000/students" className="navbar-brand">
                        Öğrenci Listesi
                        </a>
                    </div>
                </nav>
            </header>
        </div>
    )
}

export default HeaderCompononet