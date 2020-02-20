import React from "react";

export const NumberList: React.FC<{things: number[]}> = (props) => {
    const [value, setValue] = React.useState('');
    const [things, setList] = React.useState('');

    const listItems = props.things.map((number) =>
        <li key={number.toString()}>
            {number}
        </li>
    );

    const handleSubmit = (event:React.FormEvent<HTMLFormElement>) => {
        if (value) {
            setList(things.concat(value));
        }
        setValue('');
        event.preventDefault();
    };

    const handleChange = (event: React.FormEvent<HTMLInputElement>) => {
        setValue(event.currentTarget.value)
    };

    return (
        <div>
            <ul>
                {listItems}
            </ul>
            <form onSubmit={handleSubmit}>
                <input type="text" value={value} onChange={handleChange}/>
                {/*<button type="submit">Add item</button>*/}
            </form>
        </div>
    )
};
