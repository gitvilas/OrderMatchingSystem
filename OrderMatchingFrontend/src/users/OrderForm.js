import React, { useState } from 'react';
import axios from 'axios';


function OrderForm() {
    const [buyerQty, setBuyerQty] = useState('');
    const [buyerPrice, setBuyerPrice] = useState('');
    const [sellerQty, setSellerQty] = useState('');
    const [sellerPrice, setSellerPrice] = useState('');

    const handleBuySubmit = async (e) => {
        e.preventDefault();

        if (window.confirm('Are you sure you want to place this buy order?')) {
            try {
                const response = await axios.post('http://localhost:8080/orders/buy', {
                    buyerQty,
                    buyerPrice
                });

                if (response.data) {
                    alert('Buy order successfully placed!');
                    // Clear the input fields after successful submission
                    setBuyerQty('');
                    setBuyerPrice('');
                }
            } catch (error) {
                console.error('Error:', error);
            }
        } else {
            alert('Buy order placement cancelled!');
        }
    };

    const handleSellSubmit = async (e) => {
        e.preventDefault();

        if (window.confirm('Are you sure you want to place this sell order?')) {
            try {
                const response = await axios.post('http://localhost:8080/orders/sell', {
                    sellerQty,
                    sellerPrice
                });

                if (response.data) {
                    alert('Sell order successfully placed!');
                    // Clear the input fields after successful submission
                    setSellerQty('');
                    setSellerPrice('');
                }
            } catch (error) {
                console.error('Error:', error);
            }
        } else {
            alert('Sell order placement cancelled!');
        }
    };

    return (
        <div className="order-form-container">
            <div className="form-section">
                <h1>Place a Buy Order</h1>
                <form onSubmit={handleBuySubmit}>
                    <label htmlFor="buyer_qty">Buyer Quantity:</label>
                    <input
                        type="number"
                        id="buyer_qty"
                        name="buyer_qty"
                        value={buyerQty}
                        onChange={(e) => setBuyerQty(e.target.value)}
                        required
                    /><br /><br />
                    <label htmlFor="buyer_price">Buyer Price:</label>
                    <input
                        type="number"
                        id="buyer_price"
                        name="buyer_price"
                        step="0.01"
                        value={buyerPrice}
                        onChange={(e) => setBuyerPrice(e.target.value)}
                        required
                    /><br /><br />
                    <button type="submit">Place Order</button>
                </form>
            </div>
            <div className="form-section">
                <h1>Place a Sell Order</h1>
                <form onSubmit={handleSellSubmit}>
                    <label htmlFor="seller_qty">Seller Quantity:</label>
                    <input
                        type="number"
                        id="seller_qty"
                        name="seller_qty"
                        value={sellerQty}
                        onChange={(e) => setSellerQty(e.target.value)}
                        required
                    /><br /><br />
                    <label htmlFor="seller_price">Seller Price:</label>
                    <input
                        type="number"
                        id="seller_price"
                        name="seller_price"
                        step="0.01"
                        value={sellerPrice}
                        onChange={(e) => setSellerPrice(e.target.value)}
                        required
                    /><br /><br />
                    <button type="submit">Place Order</button>
                </form>
            </div>
        </div>
    );
}

export default OrderForm;
