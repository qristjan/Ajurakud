import './App.css';
import { get, map, range, set, unset } from 'lodash'
import { useCallback, useEffect, useRef, useState } from 'react';
import { v4 as uuidv4 } from 'uuid'

const socket = new window.SockJS('http://localhost:8080/gs-guide-websocket')
const stompClient = window.Stomp.over(socket)

function useReferencedCopy(value) {
  const ref = useRef()

  useEffect(() => {
    ref.current = value
  }, [value])

  return ref
}

let playerId = sessionStorage.getItem('PLAYER_ID')

if (!playerId) {
  playerId = uuidv4()
  sessionStorage.setItem('PLAYER_ID', playerId)
}

function App() {
  const [gameId, setGameId] = useState()
  const [board, setBoard] = useState({});
  const [players, setPlayers] = useState({});
  const [connected, setConnected] = useState(false);

  useEffect(() => {
    stompClient.connect({}, () => {
      setConnected(true)
    })
  }, [setConnected])

  useEffect(() => {
    if (connected && !gameId) {
      stompClient.send('/app/game/search', {}, JSON.stringify({ playerId }));
    }
  }, [connected, gameId])

  useEffect(() => {
    if (!connected || gameId) return;

    const subscription = stompClient.subscribe(`/topic/user/${playerId}/game/start`, function (data) {
      const json = JSON.parse(data.body)
      console.log(json)
      setGameId(json.id)
      setBoard(json.board.state)
      setPlayers(json.players)
    });

    return () => subscription.unsubscribe()
  }, [setBoard, setGameId, gameId, connected])

  useEffect(() => {
    if (!connected || !gameId) return;

    const subscription = stompClient.subscribe(`/topic/game/${gameId}/click`, function (data) {
      const json = JSON.parse(data.body)
      setBoard(json.game.board.state)
    });

    return () => subscription.unsubscribe()
  }, [gameId, connected, setBoard]);


  const onClick = useCallback((index) => {
    const [x, y] = index

    stompClient.send(`/app/game/${gameId}/click`, {}, JSON.stringify({ x, y, playerId }))
  }, [gameId])

  console.log(gameId)
  console.log(players)

  return (
    <div className="App">
      <main>
        {map(board, (row, y) => {
          return (
            <div className="row" key={y}>
              {map(row, (value, x) => {
                return (
                  <div className="cell" key={x} onClick={() => onClick([x, y])}>
                    {get(players, value, value)}
                  </div>
                )
              })}
            </div>
          )
        })}
      </main>
    </div>
  );
}

export default App;
