import {NextRequest, NextResponse} from "next/server";

export let balance = 200;

export async function POST(req: NextRequest) {
    if (req.cookies.has("auth-token")) {
        let url = new URL(req.url);
        let newBalance = url.searchParams.get("balance");
        if (newBalance) {
            balance = parseFloat(newBalance);
        }
        return new NextResponse();
    } else return new NextResponse(null, { status: 401 });
}