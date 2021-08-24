import { Link } from 'react-router-dom';
import Login from '../../Components/FormLogin'
import './styles.css'

const Home = ({onLogin}) => {

    return (
        <div className="container">
            <div className="header">
                <h1 className="titulo"> Desafio bycoders_</h1>
            </div>
            <div className="container2">
                <div className="box">
                    <div className="login">
                        <Login  onLogin={onLogin}/>
                    </div>
                </div>
            </div>
        </div>

    )
}

export default Home;