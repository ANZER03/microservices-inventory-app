import http from 'k6/http';
import { sleep } from 'k6';

// The default function is executed repeatedly by each Virtual User (VU)
export default function () {
    http.get('http://localhost:8888/INVENTORY-SERVICE/products');
}