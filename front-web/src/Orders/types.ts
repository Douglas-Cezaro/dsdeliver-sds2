export type Product = {
  id: number;
  name: string;
  price: number;
  description: string;
  imageUri: string;
};

export type OrderLocationData = {
  latitude: number;
  longitude: number;
  address: string;
};

type ProductId = {
  id: number;
};

// Passar mais de um tipo no type, fazer merge, para não gerar redundancia

export type OrderPayload = {
  products: ProductId[];
} & OrderLocationData;
// const teste : OrderPayload = undefined; TESTE
