import styles from "./page.module.css";
import {cookies} from "next/headers";
import {balance} from "@/app/balance/route";

export default function Page() {
    const cookieStore = cookies();
    let isLoggedIn = cookieStore.has("auth-token");

    return (
        <div className={styles.container}>
            <h1>A very secure bank</h1>
            {!isLoggedIn &&
                <a href={"/login"}>
                    <button>Login</button>
                </a>
            }
            {isLoggedIn &&
                <div>
                    <h3>your balance is {balance}</h3>
                    <a href={"/logout"}>
                        <button>Logout</button>
                    </a>
                </div>
            }
        </div>
    )
}