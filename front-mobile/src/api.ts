import Axios from "axios";
const API_URL = "https://douglas-dsdeliver.herokuapp.com";

export function fetchOrders() {
  return Axios(`${API_URL}/orders`);
}

export function confirmeDelivery(orderId: number) {
  return Axios.put(`${API_URL}/orders/${orderId}/delivered`);
}
