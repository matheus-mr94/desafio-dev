import { BrowserRouter,Route,Switch } from 'react-router-dom';
import Cadastro from '../Paginas/Cadastro';
import Home from '../Paginas/Home';
import Lojas from '../Paginas/Lojas';
import { useState, useEffect } from 'react';

function Rotas(){

    const [token, setToken] = useState("");
    const onLogin = (token) => {
      setToken(token);
    };
  
    const logout = () => {
      setToken("");
    };
  
    useEffect(() => {
      const tokenAntigo = localStorage.getItem('token')
      if (tokenAntigo) {
        setToken(tokenAntigo)
      }
    }, [])
    

    return(
        <BrowserRouter>
      
            <Switch>
                <Route exact path="/" onLogin={onLogin}>
                    <Home/>
                </Route>
                <Route path="/cadastro">
                    <Cadastro/>
                </Route>
                <Route path="/lojas">
                    <Lojas/>
                </Route>
            </Switch>
        </BrowserRouter>
    )
}

export default Rotas;