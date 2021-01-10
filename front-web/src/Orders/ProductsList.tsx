import ProductsCard from "./ProductCard";
import { Product } from "./types";

type Props = {
  products: Product[];
};

export default function ProductsList({ products }: Props) {
  return (
    <div className="orders-list-container">
      <div className="orders-list-items">
        {products.map((product) => (
          <ProductsCard product={product} key={product.id} />
        ))}
      </div>
    </div>
  );
}
