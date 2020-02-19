import React from "react";

export const NumberList: React.FC<{things: number[]}> = (props) => {
    const listItems = props.things.map((number) =>
        <li key={number.toString()}>
            {number}
        </li>
    );
    return (
        <ul>
            {listItems}
        </ul>
    )
};
